package reversi;

import java.util.LinkedList;

import reversi.Cell.CellState;
import fge.Color;
import fge.Render;
import fge.Texture;

public class Board {
	
	public enum Direction {
		LEFT(-1,0),
		RIGHT(1,0),
		UP(0,-1),
		DOWN(0,1),
		LEFT_UP(-1,-1),
		RIGHT_UP(1,-1),
		LEFT_DOWN(-1,1),
		RIGHT_DOWN(1,1);
		
		private int x, y;
		
		Direction(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() { return x; }
		public int getY() { return y; }
	}
	
	public enum PieceColor {
		BLACK, WHITE;
		
		public PieceColor opposite() {
			if (this == PieceColor.BLACK) return PieceColor.WHITE;
			return PieceColor.BLACK;
		}
		
		public CellState toCellState() {
			if (this == PieceColor.BLACK) return CellState.BLACK;
			return CellState.WHITE;
		}
	}
	
	private int m_Cols;
	private int m_Rows;
	private int m_CellSize;
	
	private float m_X;
	private float m_Y;
	
	private Texture texBackground;
	private Texture texPieceBlack;
	private Texture texPieceWhite;
	private Texture texValid;
	
	private Cell[] boardCells;
	private int blackPieces = 0;
	private int whitePieces = 0;
	private int totalPieces = 0;
	
	public Board(int _cols, int _rows) {
		m_Cols = _cols;
		m_Rows = _rows;
		m_CellSize = 64;
		
		texBackground = new Texture("PNG", "data/reversi_board512.png");
		texPieceBlack = new Texture("PNG", "data/piece_black64.png");
		texPieceWhite = new Texture("PNG", "data/piece_white64.png");
		texValid = new Texture("PNG", "data/valid64.png");
		
		boardCells = new Cell[m_Cols * m_Rows];
		for (int i = 0; i < boardCells.length; i++) boardCells[i] = new Cell();
	}

	public void setX(float _x) { m_X = _x; }
	public void setY(float _y) { m_Y = _y; }
	public void setPos(float _x, float _y) { m_X = _x; m_Y = _y; }
	public float getX() { return m_X; }
	public float getY() { return m_Y; }
		
	public int getW() { return m_Cols * m_CellSize; }
	public int getH() { return m_Rows * m_CellSize; }
	public int getCols() { return m_Cols; }
	public int getRows() { return m_Rows; }
	public int getCellSize() { return m_CellSize; }
		
	public void Draw() {
		
		Render.DrawTex(texBackground, m_X - 24, m_Y - 24, 560, 560, new Color(255,255,255));
		
		for (int i = 0; i < boardCells.length; i++) {
			float x = m_X + (i % m_Cols) * m_CellSize;
			float y = m_Y + (i / m_Cols) * m_CellSize;
			//boardCells[i].Draw(_x, _y);
			if (boardCells[i].getState() == CellState.BLACK)
				Render.DrawTex(texPieceBlack, x, y, 64, 64, new Color(255,255,255));
			else if (boardCells[i].getState() == CellState.WHITE)
				Render.DrawTex(texPieceWhite, x, y, 64, 64, new Color(255,255,255));
			else if (boardCells[i].getState() == CellState.EMPTY && boardCells[i].getFlipDirections().size() > 0)
				Render.DrawTex(texValid, x, y, 64, 64, new Color(255,255,255));
		}
		
	}
	
	public void AddPiece(int col, int row, PieceColor color) {
		int i = row * m_Cols + col;
		AddPiece(i, color);
	}

	public void AddPiece(int i, PieceColor color) {
		
		boardCells[i].setState(color.toCellState());
		totalPieces = (color == PieceColor.BLACK) ? ++blackPieces + whitePieces : ++whitePieces + blackPieces;
		
		for (Direction direction : boardCells[i].getFlipDirections()) {
			
			int i2 = i + direction.getX() + direction.getY() * m_Cols;
			while (i2 >= 0 && i2 < boardCells.length && boardCells[i2].getState() == color.opposite().toCellState()) {
				boardCells[i2].setState(color.toCellState());
				totalPieces = (color == PieceColor.BLACK) ? ++blackPieces + --whitePieces : ++whitePieces + --blackPieces;
				i2 += direction.getX() + direction.getY() * m_Cols;
			}
			
		}
		
	}
	
	public void RemovePiece(int col, int row) {
		int i = row * m_Cols + col;
		RemovePiece(i);
	}
	
	public void RemovePiece(int i) {
		boardCells[i].setState(CellState.EMPTY);
	}
	
	public void FlipPiece(int col, int row) {
		int i = row * m_Cols + col;
		FlipPiece(i);
	}
	
	public void FlipPiece(int i) {
		boardCells[i].flip();
	}
	
	
	public Cell getCell(int col, int row) {
		int i = row * m_Cols + col;
		return getCell(i);
	}
	
	public Cell getCell(int i) {
		return boardCells[i];
	}
		
	
	public Cell[] getBoardCells() {
		Cell[] bc = new Cell[boardCells.length];
		for (int i = 0; i < boardCells.length; i++) bc[i] = new Cell(boardCells[i]);
		return bc;
	}
	
	public void setBoardCells(Cell[] bc) {
		for (int i = 0; i < boardCells.length; i++) boardCells[i] = new Cell(bc[i]);
	}
	
	
	private LinkedList<Direction> getFlipDirections(int boardIndex, PieceColor color) {
		
		LinkedList<Direction> flipDirections = new LinkedList<Direction>();
		
		if (boardIndex >= 0 && boardIndex < boardCells.length && boardCells[boardIndex].getState() == CellState.EMPTY) {
						
			int col = boardIndex % m_Cols;
			int row = boardIndex / m_Cols;
			
			for (Direction direction : Direction.values()) {
				
				int dx = direction.getX();
				int dy = direction.getY();
								
				int col2 = col + dx;
				int row2 = row + dy;
				int boardIndex2 = row2 * m_Cols + col2;
				
				if (col2 >= 0 && col2 < m_Cols && row2 >= 0 && row2 < m_Rows && boardCells[boardIndex2].getState() == color.opposite().toCellState()) {
						
					col2 += dx;
					row2 += dy;
					boardIndex2 = row2 * m_Cols + col2;
					
					while (col2 >= 0 && col2 < m_Cols && row2 >= 0 && row2 < m_Rows)
					{
						if (boardCells[boardIndex2].getState() == CellState.EMPTY) break;
						if (boardCells[boardIndex2].getState() == color.toCellState()) {
							flipDirections.add(direction);
							break;
						}				
						
						col2 += dx;
						row2 += dy;
						boardIndex2 = row2 * m_Cols + col2;
					}
						
				}
				
			}
						
		}
		
		return flipDirections;
		
	}
	
	public boolean setCurrentColor(PieceColor color) {
		
		boolean legalMoves = false;
		for (int i = 0; i < boardCells.length; i++) {
			LinkedList<Direction> flipDirections = getFlipDirections(i, color);
			if (flipDirections.size() > 0) {
				boardCells[i].setFlipDirections(flipDirections);
				legalMoves = true;
			} else {
				boardCells[i].setFlipDirections(flipDirections);
			}
		}
		return legalMoves;
		
	}
	
	public int getBlackPieces() { return blackPieces; }
	public int getWhitePieces() { return whitePieces; }
	public int getTotalPieces() { return totalPieces; }
	
	public Board getCopy() {
		Board b2 = new Board(m_Cols, m_Rows);
		return b2;
	}
	
}
