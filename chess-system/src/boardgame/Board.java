package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public Piece piece(int rows, int columns) {
		return pieces[rows][columns];
	}

	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColunm()];
	}

	/**
	 * 
	 * @param piece na linha e coluna da matriz de pe�as, atribuir a pe�a informada pelo jogador
	 * @param position a posi��o da pe�a passa de nula para a posi��o movimentada pelo jogador 
	 */
	public void placePiece(Piece piece, Position position) {
		pieces[position.getRow()][position.getColunm()] = piece;
		piece.position = position;
	}
	
}
