package com.piniponselvagem.tetris.model.piece;

public interface PieceListener {
    void whenPieceShow(Piece piece, int blocks);
    void whenPieceHide(Piece piece, int blocks);
}
