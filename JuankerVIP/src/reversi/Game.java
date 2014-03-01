package reversi;

import java.util.LinkedList;

import reversi.Board.PieceColor;

import fge.Color;
import fge.Event;
import fge.Event.EventType;
import fge.EventListener;
import fge.EventMan;
import fge.Font;
import fge.Keyboard;
import fge.Mouse;
import fge.Render;
import fge.Service;
import fge.Texture;
import fge.Window;

public class Game extends Service implements EventListener {
	
	private class GameState {
		private Player currentPlayer;
		private Cell[] boardCells;
		
		public GameState(Player currentPlayer, Cell[] boardCells) {
			this.currentPlayer = currentPlayer;
			this.boardCells = boardCells;
		}
	}
	
	private Texture texBackground;
	
	private LinkedList<GameState> prevGameStates = new LinkedList<GameState>();
	private LinkedList<GameState> nextGameStates = new LinkedList<GameState>();
	
	private Player playerBlack;
	private Player playerWhite;
	private Player currentPlayer;
	
	private Board board;
	
	private Font font;
	
	//private GameState gameState
	
	@Override
	public void onStart() {
		
		EventMan.addListener(this);
		
		texBackground = new Texture("data/grey_wash_wall512.png");
		
		playerBlack = new Player("Player 1", PieceColor.BLACK, true);
		playerWhite = new Player("Player 2", PieceColor.WHITE, false);
		currentPlayer = playerBlack;
		
		board = new Board(8, 8);
		board.setPos((Window.getW() - board.getW()) / 2, (Window.getH() - board.getH()) / 2);
		board.AddPiece(3, 3, PieceColor.WHITE);
		board.AddPiece(4, 3, PieceColor.BLACK);
		board.AddPiece(3, 4, PieceColor.BLACK);
		board.AddPiece(4, 4, PieceColor.WHITE);
		board.setCurrentColor(currentPlayer.getColor());
		
		font = new Font("data/andrewsc.ttf", 48.0f);
		
	}
	
	@Override
	public void onStop() {
	
	}
	
	@Override
	public void onMove() {
		
	}
	
	@Override
	public void onDraw()  {
		Render.DrawTex(texBackground, 0, 0, Window.getW(), Window.getH(), new Color(255,255,255), 0, 0, 800 / 350.f, 600 / 259.f);
		board.Draw();
		font.Draw(16, 16, "Black: " + board.getBlackPieces() + "  -  White: " + board.getWhitePieces(), new Color(255,0,0));
	}
	
	@Override
	public boolean doEvent(Event e) {
		if (e.getType() == EventType.MOUSE_PRESSED) {
			
			int mx = Mouse.getX();
			int my = Mouse.getY();	
			int bx = (int) (mx - board.getX());
			int by = (int) (my - board.getY());
			
			if (bx >= 0 && bx < board.getW() && by >= 0 && by < board.getH()) {
				int cx = bx / board.getCellSize();
				int cy = by / board.getCellSize();
				int ci = cy * board.getCols() + cx;
				
				if (board.getCell(ci).isValidMove()) {
					
					// Save current GameState
					prevGameStates.add(new GameState(currentPlayer, board.getBoardCells()));
					
					board.AddPiece(cx, cy, currentPlayer.getColor());
					
					currentPlayer = (currentPlayer == playerBlack) ? playerWhite : playerBlack;
					if (!board.setCurrentColor(currentPlayer.getColor())) {
						
						currentPlayer = (currentPlayer == playerBlack) ? playerWhite : playerBlack;
						if (!board.setCurrentColor(currentPlayer.getColor())) {
							// Game Over
						}
						
					}
					
					if (!currentPlayer.isHuman()) {
						currentPlayer.chooseLegalMove(board);
					}
					
				}
				
				return true;
			}
			
		} else if (e.getType() == EventType.KEY_RELEASED) {
			if (e.getValue() == Keyboard.KEY_LEFT) {
				undoMove();
			}
			if (e.getValue() == Keyboard.KEY_RIGHT) {
				redoMove();
			}
		}
		return false;
	}
	
	public boolean hasPrevGameStates() { return !prevGameStates.isEmpty(); }
	
	public void undoMove() {
		if (!prevGameStates.isEmpty()) {
			nextGameStates.add(new GameState(currentPlayer, board.getBoardCells()));
			GameState gs = prevGameStates.removeLast();
			currentPlayer = gs.currentPlayer;
			board.setBoardCells(gs.boardCells);
		}		
	}
	
	public boolean hasNextGameStates() { return !nextGameStates.isEmpty(); }
	
	public void redoMove() {
		if (!nextGameStates.isEmpty()) {
			prevGameStates.add(new GameState(currentPlayer, board.getBoardCells()));
			GameState gs = nextGameStates.removeLast();
			currentPlayer = gs.currentPlayer;
			board.setBoardCells(gs.boardCells);
		}	
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		
	}
	
	////////////////////////////////////////////////////////////////////////
	
	//private void Flipping
	
}
