package com.piniponselvagem.tetris.game.view;


import android.graphics.Canvas;
import android.graphics.Paint;

import com.piniponselvagem.tetris.game.model.piece.Piece;

import pt.isel.poo.tile.Tile;
import pt.isel.poo.tile.TilePanel;

public abstract class TetrisView implements Tile {
    protected static Paint paint = new Paint();

    static {
        paint.setStyle(Paint.Style.FILL);
    }

    protected Piece piece;
    protected static int heightInTiles, widthInTiles;
    public TetrisView(Piece piece) {
        this.piece = piece;
    }

    public TetrisView() {
    }

    public static void setTileLimits(TilePanel tile) {
        heightInTiles = tile.getHeightInTiles();
        widthInTiles  = tile.getWidthInTiles();
    }

    public abstract void draw(Canvas canvas, int side);

    public abstract void setColor(int color);

    /*
    public static int getColor() {
        switch () {
            case 1:  return Color.rgb(238,  0,  0);
            case 2:  return Color.rgb(  0,151,214);
            case 3:  return Color.rgb(242,183,  0);
            case 4:  return Color.rgb(250,250,  0);
            case 5:  return Color.rgb(252, 81,139);
            case 6:  return Color.rgb( 74,235,235);
            case 7:  return Color.rgb(144,205, 76);
            default: return 0;
        }
    }
    */


    /*
    public void showGameOverMsg() {
        gameOverScreen(1, Console.RED, Console.YELLOW);
        Console.print(GAME_OVER_TXT);		// Message GAME OVER

        Console.waitKeyPressed(5000);		// Wait 5 seconds for any key
        while (Console.isKeyPressed())
            ;

        gameOverScreen(2, Console.BLACK, Console.WHITE);
        Console.print(NEW_GAME_TXT);		// Ask for a new game

        gameOverScreen(3, Console.BLACK, Console.WHITE);
        Console.print(Y_N_TXT);				// Message for wish keys are recognized
    }

    private void gameOverScreen(int line, int foreground, int background) {
        int gameOverCol=0;
        if (GAME_OVER_TXT.length()/2<modelInfo.getDimCols() && modelInfo.getDimCols()>GAME_OVER_TXT.length())
            gameOverCol=(modelInfo.getDimCols()-GAME_OVER_TXT.length())/2;
        Console.cursor(modelInfo.getBaseLin()+line, gameOverCol+modelInfo.getBaseCol());
        Console.color(foreground, background);
    }
    */
}
