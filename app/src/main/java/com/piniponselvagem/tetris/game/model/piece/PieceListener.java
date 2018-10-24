package com.piniponselvagem.tetris.game.model.piece;

public interface PieceListener {
    void whenPieceShow(Piece piece, int blocks);
    void whenPieceHide(Piece piece, int blocks);
}
