# Tetris_Android
My first game ported to android


# Old changelog file
----------------------------------------------------------------------------------------
                                    PiniponSelvagem
                                     ---TETRIS---
                                   ALPHA 1  Android
----------------------------------------------------------------------------------------

> TETRIS GAME:
	Tetris game in Java , with many customization options .
	Changing colors, position of the pieces counters, score multiplier, music and more.

	
> LEGEND:
	RC    > release candidate
	+ ADD > added
	- REM > removed
	# FIX > bug fixed
	! INFO> informative message
	
	version X.Y.Z
	X > major update
	Y > incremented by day
	Z > only used if more than 1 update per day
	
	
> CHANGELOG: (order: from later to older)
	> ALPHA 0.3  (22062016)
		# FIX:	Incorrect draw piece when line deleted.
		+ ADD:	Draw line delete and moved.

	> ALPHA 0.2	 (21062016)
		! INFO: Implementing PieceView.
				Ran into trouble setting the piece color, all object of PieceView were
				having the same color, Fixed it by moving the getColor from TetrisView
				to Piece for now.

	> ALPHA 0.1  (20062016)
		! INFO: This version will be a port from Tetris Console v1.2.
		! INFO:	Started Android Studio Project.
		+ ADD:	activity_game, will be used for the state of the game.
		+ ADD:	Custom Theme, Orange/Black.

	
	
	\/\/\/ CONSOLE \/\/\/
	
	> v1.2 	 (22012015)
		! INFO: Score per line no longer has a fixed variable.
				Now dependent from: Score.SCORE_MINIBLOCK and Board.DIM_COLS.
				Equation now is: "Score.scoreCalc(DIM_COLS*Score.SCORE_MINIBLOCK)"

	> v1.1.1 (19012015)
		# FIX:  Incorrect collision detection on new piece.
				Collision box size was: 4x3 (increased to 4x4).
		# FIX:  Next Piece was updating when "Game Over" occurred. 
	
	> v1.1 	 (19012015)
		# FIX:	Line counter, not counting lines. (bug was introduced after the rework)

	> v1.0 	 (17012015)
		! INFO: Initial Release.
		+ ADD:  New comments for better interpretation.
		- REM:  Redundant code when drawing pieces
		# FIX:  Incorrect score calculation when deleting lines.
		# FIX:  Faster Pieces counters, only updates the counter for 1 type per turn.

	> RC 1.2
		- REM:	Redundant code while displaying Piece on Board.
		# FIX:	Improved algorithm when saving Piece, no longer "writes" the Piece on
				the Board, instead only saves it. To "write" it, call draw(...).
		! INFO:	gameOver moved from "main" to "clearNewGame".
		# FIX:	Now adding additional text to the KEYMAP_TXT, adds 1 more line at the
				bottom. This way KEYMAP_TXT never touches the bottom of the window.
		# FIX:	Small changes, specially method names.
		# FIX:	Bugs introduced after the new saving algorithm:
				* Score not counting Lines.
				* Incorrect time while "PAUSE".
		- Removed White Piece.
	
	> RC 1.1
		- REM:	Array boardCopy deprecated, new algorithm can copy the above line and
				move it down.
		# FIX:	Effects adjusted according to new way of handling with moving lines.
				(arrays: 1)
		- REM:	Redundant code when deleting and moving lines.
		- Removed White Piece.
	
	> RC 1.0
		+ ADD:	Customizable Piece counter position.
		+ ADD:	More constants for personalisation:
				BOARD:
					* WAIT » waiting time in milliseconds to delete next line.
				SCORE:
					* SCORE_SHOW   » if true will draw the Score in-game.
					* KEYMAP_SHOW  » if true will draw the KeyMap in-game.
					* CR_FOREG_XXX » changes the color of the foreground for "XXX".
					* CR_BACKG_XXX » changes the color of the background for "XXX".
					* H_POS_X and V_POS_X » changes piece counter position.
					* MUSIC » write the name of the song that you want to be heard
							  in-game without the extension (music in .wav).
							  Music file goes to sound folder.
					* MUSIC_STATE  » if true will start playing the music when game
									 starts.
		- REM:	Array lineCheck deprecated, new algorithm can check if line is full.
		- Removed White Piece
		
	> BETA 0.2
		# FIX:	Changing board size and/or board starting position no longer crashes.
		+ ADD:	Score now works.
		+ ADD:	Constants for score and line multiplier, next level in 'X' Pieces.
		+ ADD:	Pieces counters.
		! INFO: Improved "Board.lineCheck()".
		+ ADD:	Music!!!
		- Removed White Piece
	
	> BETA 0.1
		! INFO: Now in beta stage.
		+ ADD:	CLASS: "Score"
		+ ADD:	KeyMap and Score (only 1st stage)	
		- Removed White Piece
	
	> ALPHA 0.3
		+ ADD:	Array to copy main one and then move down.
				(arrays: 3)
		! INFO:	Collision, delete line and moving lines down: working.
		# FIX:	Improved collision detection. Checks if it is possible to add new Piece.
				Top row not moves and deletes.
		+ ADD:	Line deleting effects.
	
	> ALPHA 0.2
		# FIX:	Faster board drawing.
		+ ADD:	Array now saves game state and piece color.
		+ ADD:	Piece collision.
		+ ADD:	Array to check if line is full.
				(arrays: 2)
		! INFO:	Line now deletes, but not moving down for now.
	
	> ALPHA 0.1
		+ ADD:	Increased window size for later use. (score and key-map)
		! INFO:	Piece now stays when hitting the ground, but as a ghost.
		+ ADD:	Array to save game state.
		