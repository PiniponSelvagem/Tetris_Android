package com.piniponselvagem.tetris.model.board;


public interface BoardListener {
    void whenLineDelete(int lin);
    void requestDrawLine(int lin);
}
