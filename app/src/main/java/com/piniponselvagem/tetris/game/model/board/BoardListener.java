package com.piniponselvagem.tetris.game.model.board;


public interface BoardListener {
    void whenLineDelete(int lin);
    void requestDrawLine(int lin);
}
