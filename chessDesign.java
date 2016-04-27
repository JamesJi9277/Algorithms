public class Game {
	private Board board = new Board();
	private Player white;
	private Player black;
	public Game() {
		super();
	}
	public void setColorWhite(Player player) {
		this.white = player;
	}
	public void setColorBlack(Player player) {
		this.black = black;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Player getWhite() {
		return white;
	}
	public Player getBlack() {
		return black;
	}
	public void setWhite(Player player) {
		this.white = player;
	}
	public void setBlack(Player player) {
		this.black = player;
	}

	public boolean initializeBoardGivenPlayers() {
		if(this.black == null || this.white == null) {
			return false;
		}
		this.board = new Board();
		for(int i = 0; i < black.getPieces().size(); i++) {
			board.getSpot(black.getPieces().get(i).getX(), black.getPieces().get(i).getY()).occupySpot(black.getPieces().get(i));
		}
		return true;
	}
}


public class Player {
	public final int Pawn = 8;
	public final int Bishop = 2;
	public final int Rook = 2;
	public boolean white;
	private List<Piece> pieces = new ArrayList<>();

	public Player(boolean white) {
		super();
		this.white = white;
	}
	public List<Piece> getPieces() {
		return pieces;
	}

	public void initialPieces() {
		if(this.white == true) {
			for(int i = 0; i < Pawn; i++) {
				pieces.add(new Pawn(true, i, 2));
			}
			pieces.add(new Rook(true, 0, 0));
			pieces.add(new Rook(true, 7, 0));
			pieces.add(new Bishop(true, 2, 0));
			pieces.add(new Bishop(true, 5, 0));
			pieces.add(new Knight(true, 1, 0));
			pieces.add(new Knight(true, 6, 0));
			pieces.add(new Queen(true, 3, 0));
			pieces.add(new King(true, 4, 0));
		}
		else {
			for(int i = 0; i < Pawn; i++) {
				pieces.add(new Pawn(true, i, 6));
			}
			pieces.add(new Rook(true, 0, 7));
			pieces.add(new Rook(true, 7, 7));
			pieces.add(new Bishop(true, 2, 7));
			pieces.add(new Bishop(true, 5, 7));
			pieces.add(new Knight(true, 1, 7));
			pieces.add(new Knight(true, 6, 7));
			pieces.add(new Queen(true, 3, 7));
			pieces.add(new King(true, 4, 7));
		}
	}
	public void move(Piece piece, int fromX, int toX, int fromY, int toY) {
		switch(piece) {
			case (Rook):
			if(Rook.isValid(piece, fromX, toX, fromY, toY)) {
				if(checkMate()) {
					Game.setGameOver();
				}
			}
		}
	}
}

public class Board {
	private Spot[][] spots = new Spot[8][8];
	public Board() {
		super();
		for(int i = 0; i < spots.length; i++) {
			for(int j = 0; j < spots[0].length; j++) {
				spots[i][j] = new Spot(i, j);
			}
		}
	}
	public Spot getSpot(int x, int y) {
		return spots[x][y];
	}
}

public class Spot {
	int x;
	int y;
	Piece piece;
	public Spot(int x, int y) {
		this.x = x;
		this.y = y;
		piece = null;
	}
	public void occupySpot(Piece piece) {
		if(piece ！= null) {
			this.piece.setAvailable(false);
		}
		this.piece = piece;
	}
	public boolean isOccupied() {
		if(piece != null) {
			return true;
		}
		return false;
	}
	public Piece releaseSpot() {
		Piece releasedPiece = this.piece;
		this.piece = null;
		return releasedPiece;
	}
}

public class Piece {
	private boolean available;
	private int x;
	private int y;

	public Piece(boolean available, int x, int y) {
		this.available = available;
		this.x = x;
		this.y = y;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
		if(toX == fromX || toY == fromY) {
			return false;
		}
		if(fromX < 0 || fromX >= board.length || toX < 0 || toX >= board.length || fromY < 0 || fromY >= board[0].length || toY < 0 || toY >= board[0].length) {
			return false;
		}
		return true;
	}
}
public class King extends Piece {
	public King(boolean available, int x, int y) {
		super(available, x, y);
	}
	@Override
	public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
		if(super.isValid(board, fromX, fromY, toX, toY) == false) {
			return false;
		}
		if(Math.sqrt(Math.pow(Math.abs(fromX - toX),2) + Math.pow(Math.abs(fromY, toY),2)) != Math.sqrt(2)) {
			return false;
		}
		return true;
	}
}

public class Knight extends Piece {
	public Knight(boolean available, int x, int y) {
		super(available, x, y);
	}
	@Override
	public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
		if(super.isValid(board, fromX, fromY, toX, toY) == false) {
			return false;
		}
		if(toX != fromX - 1 || toX != fromX + 1 || toX != fromX + 2 || toX != fromX - 2) {
			return false;
		}
		if(toY != fromY - 1 || toY != fromY + 1 || toY != fromY + 2 || toY != fromY - 2) {
			return false;
		}
		return true;
	}
}

public class Bishop extends Piece {
	public Bishop(boolean available, int x, int y) {
		super(available, x, y);
	}
	@Override
	public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
		if(super.isValid(board, fromX, fromY, toX, toY) == false) {
			return false;
		}
		//这里指的是白的只能在白的走，黑的只能在黑的走并且只能斜着走
		if(toX - fromX == toY - fromY) {
			return true;
		}
		return false;
	}
}
public class Rook extends Piece {
	public Rook(boolean available, int x, int y) {
		super(available, x, y);
	}
	@Override
	public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
		if(super.isValid(board, fromX, fromY, toX, toY) == false) {
			return false;
		}
		if(toX == fromX) {
			return true;
		}
		if(toY == fromY) {
			return true;
		}
		return false;
	}
}
public class Queen extends Piece {
	public Queen(boolean available, int x, int y) {
		super(available, x, y);
	}
	public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
		if(super.isValid(board, fromX, fromY, toX, toY) == false) {
			return false;
		}
		if(toX - fromX == toY - fromY) {
			return true;
		}
		if(toX == fromX || toY == fromY) {
			return true;
		} 
		return false;
	}
}
public class Pawn entends Piece {
	public Pawn(boolean available, int x, int y) {
		super(available, x, y);
	}
	public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
		if(super.isValid(board, fromX, fromY, toX, toY) == false) {
			return false;
		}
		if(toX = 1 + fromX && toY == fromY) {
			return true;
		}
		return false;
	}
}