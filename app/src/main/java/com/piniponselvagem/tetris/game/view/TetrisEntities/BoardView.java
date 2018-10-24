package com.piniponselvagem.tetris.game.view.TetrisEntities;


import android.graphics.Canvas;

import com.piniponselvagem.tetris.game.model.piece.Piece;
import com.piniponselvagem.tetris.game.view.TetrisView;

public class BoardView extends TetrisView {
    public BoardView(Piece piece) {
        super(piece);
    }

    @Override
    public void draw(Canvas canvas, int side) {

    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }

    @Override
    public void setColor(int color) {

    }
}
