package com.piniponselvagem.tetris;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.piniponselvagem.tetris.model.board.Board;
import com.piniponselvagem.tetris.model.board.BoardListener;
import com.piniponselvagem.tetris.model.piece.Piece;
import com.piniponselvagem.tetris.model.piece.PieceListener;
import com.piniponselvagem.tetris.view.TetrisEntities.PieceView;
import com.piniponselvagem.tetris.view.TetrisView;

import pt.isel.poo.tile.OnBeatListener;
import pt.isel.poo.tile.TilePanel;

public class GameActivity extends AppCompatActivity implements View.OnTouchListener, OnBeatListener, PieceListener, BoardListener {
    private Board board;
    private Piece piece;                      // Current piece controlled
    private TilePanel panel;
    private static final int STEP_TIME = 1000; // 1 second by each step
    private static final boolean TIMED = true;

    public static long waitTime;
    public static long nextStepTime;  		  // Time to call next step()
    private int startX, startY, endX, endY;
    public static boolean gameOver;

    public GameActivity() {
        this.board = new Board();
        Piece.calcNextPiece();
        this.piece = new Piece();
        Piece.calcNextPiece();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        this.panel = (TilePanel) findViewById(R.id.panel);
        this.panel.setOnTouchListener(this);
        this.panel.setSize(this.board.getDimCols(), this.board.getDimLines());
        this.panel.setHeartbeatListener(STEP_TIME, this);
        this.piece.setPieceListener(this);
        this.board.setBoardListener(this);
        startBoardScore();
    }


    @Override
    public void onBeat(long beat, long time) {
        step();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case (MotionEvent.ACTION_DOWN):
                this.startX = (int) event.getX();
                this.startY = (int) event.getY();
                return TIMED;
            case (MotionEvent.ACTION_UP):
                this.endX = (int) event.getX();
                this.endY = (int) event.getY();
                if (Math.abs(this.startY - this.endY) > Math.abs(this.startX - this.endX) && this.startY > this.endY) {
                    piece.rotateRight();
                    return TIMED;
                } else if (Math.abs(this.startY - this.endY) > Math.abs(this.startX - this.endX) && this.startY < this.endY) {
                    //System.out.println("DOWN");
                    piece.downFast();
                    return TIMED;
                } else if (Math.abs(this.startX - this.endX) > Math.abs(this.startY - this.endY) && this.endX < this.startX) {
                    //System.out.println("LEFT");
                    piece.moveLeft();
                    return TIMED;
                } else if (Math.abs(this.startX - this.endX) > Math.abs(this.startY - this.endY) && this.endX > this.startX) {
                    //System.out.println("RIGHT");
                    piece.moveRight();
                    return TIMED;
                }
                return TIMED;
            default:
                return false;
        }
    }

    private void step() {
        if (!piece.down()) {   			    // If possible, move the piece down
            piece.solid();					// Make piece solid
            Piece.type = Piece.nexttype;    // Places the "next" piece in the game to play
            piece = new Piece();			// Create a new piece of random type
            piece.setPieceListener(this);
            piece.isGameOver();
            if (!gameOver) {
                piece.show(); 				// Show the new piece
                Piece.calcNextPiece();		// Calculates the next piece for next turn
            }
        }
    }

    private void startBoardScore() {
        TetrisView.setTileLimits(panel);
        Board.board = new int[Board.DIM_LINES][Board.DIM_COLS];
    }

    private static void clearNewGame() { // Clears for a new game
        gameOver=false;
    }

    private boolean terminate() {
        return false;
    }

    @Override
    public void whenPieceShow(Piece piece, int blocks) {
        int mask = Piece.MASK_INIT;
        for(int l=0; l<Piece.GRID_LINES ; ++l)				// For each line
            for(int c=0; c<Piece.GRID_COLS ; ++c , mask>>=1 )	// For each column
                if ((blocks&mask)!=0) { 				// If has a block
                    PieceView pieceView = new PieceView(piece);
                    pieceView.setColor(Piece.COLORS[Piece.type]);
                    this.panel.setTile(piece.getColumn() + c, piece.getLine() + l, pieceView);
                    this.panel.invalidate(piece.getColumn()+c, piece.getLine()+l);
                }
    }

    @Override
    public void whenPieceHide(Piece piece, int blocks) {
        int mask = Piece.MASK_INIT;
        for(int l=0; l<Piece.GRID_LINES ; ++l)				// For each line
            for(int c=0; c<Piece.GRID_COLS ; ++c , mask>>=1 )	// For each column
                if ((blocks&mask)!=0) { 				// If has a block
                    this.panel.setTile(piece.getColumn()+c, piece.getLine()+l, null);
                    this.panel.invalidate(piece.getColumn()+c, piece.getLine()+l);
                }
    }

    @Override
    public void whenLineDelete(int lin) {
        for(int c=0; c<Board.DIM_COLS ; ++c ) {	// For each column
            this.panel.setTile(c, lin, null);
            this.panel.invalidate(c, lin);
        }
    }

    @Override
    public void requestDrawLine(int lin) {
        for(int c=0; c<Board.DIM_COLS ; ++c ) {	// For each column
            PieceView v = new PieceView(Board.board[lin][c]);
            this.panel.setTile(c, lin, v);
            this.panel.invalidate(c, lin);
        }
    }
}
