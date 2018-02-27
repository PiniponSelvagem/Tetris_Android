package com.piniponselvagem.tetris.model.board;


public class Board {
    private static BoardListener listener;
	public static final int
		DIM_LINES = 20, DIM_COLS = 10,
		WAIT = 50;
		/* WAIT -> How long 'X' stays when deleting line.
		 *         Affects lineDelete time, also see "Board.lineDeleteEffect()"
		 */

    public void setBoardListener(BoardListener listener) {
        Board.listener = listener;
    }

	public static int[][] board;

	public int getDimLines() {
		return DIM_LINES;
	}

	public int getDimCols() {
		return DIM_COLS;
	}

	public static boolean validPosition(int line, int col) {
		return line>=0 && line<DIM_LINES && col>=0 && col<DIM_COLS && board[line][col]==0;
	}

	public static void lineCheck() {
		boolean recheck=false;
		do {
			for (int line=DIM_LINES-1; line>0 ; --line) {
	    		recheck=false;
				int count=0;
	    		for (int col=0 ; col<DIM_COLS ; ++col) {
	    			if (board[line][col]!=0) ++count;	// counts the "mini" blocks on the line
	    			if (count==DIM_COLS) recheck=true;	// goes true when line is full
	    		}
	    		if (count==0) break; //check if line is empty, breaks and game continues
	    		if (count==DIM_COLS) {
	    			//lineDeleteEffect(line,'X', WAIT*6);
                    //listener.whenLineDelete(line);
	    			lineDelete(line);
	    			//linePause(WAIT);
	    			//lineDraw(line);
	    			lineMove(line-1); //moves next line down, '1' because its the line above.
	    			//Score.scoreCalc(DIM_COLS * Score.SCORE_MINIBLOCK);
	    			//Score.linesCalc(1); //increments lines counter
                    listener.requestDrawLine(line);
                    listener.requestDrawLine(line-1);
	    			break; //if not here, will only delete max 2 lines per turn, leaves this 'for' and do 'recheck'.
	    		}
			}
		}	while(recheck);
	}
	
	private static void lineDelete(int line) {
		if (line>0) {
			board[line]=board[line-1];
			board[line-1]=new int[DIM_COLS];
		} else 
			board[line]=new int[DIM_COLS];
		for (int col=0 ; col<DIM_COLS; ++col)
            listener.whenLineDelete(line);
			//gridShow(line+BASE_LINE,col)
			;
		
	}
	
	private static void lineMove(int line) {
		int count;
		while (line>=0) {
			lineDelete(line);
			//linePause(WAIT);
            listener.requestDrawLine(line);
			//lineDraw(line);  //shows replaced line
			
			count=0; //resets counter
			for (int col=0 ; col<DIM_COLS; ++col) { //checks if needs to continue moving pieces (is the line empty?)
				if (board[line][col]!=0) ++count;
			}
			if (count==0) break;
			--line; //goes to next line above
		}
	}


	public static void linePause(int wait) {
		//TetrisCtrl.nextStepTime+=wait; //stops the timer for "WAIT"ms
		//Console.sleep(wait);
	}
}