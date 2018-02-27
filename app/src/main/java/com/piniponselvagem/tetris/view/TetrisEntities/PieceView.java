package com.piniponselvagem.tetris.view.TetrisEntities;


import android.graphics.Canvas;
import android.graphics.Rect;

import com.piniponselvagem.tetris.model.piece.Piece;
import com.piniponselvagem.tetris.view.TetrisView;

public class PieceView extends TetrisView {
    private int color;

    public PieceView(Piece piece) {
        super(piece);
    }

    public PieceView(int color) {
        super();
        setColor(color);
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public void draw(Canvas canvas, int side) {
        paint.setColor(color);
        Rect r = canvas.getClipBounds();
        canvas.drawRect(r, paint);
    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}
