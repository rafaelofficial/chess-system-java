package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column!");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int rows, int columns) {
		if (!positionExists(rows, columns)) {
			throw new BoardException("Position not on the board!");
		}
		return pieces[rows][columns];
	}

	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board!");
		}
		return pieces[position.getRow()][position.getColunm()];
	}

	/**
	 * @param piece    na linha e coluna da matriz de peças, atribuir a peça informada pelo jogador
	 * @param position a posição da peça passa de nula para a posição movimentada pelo jogador
	 */
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColunm()] = piece;
		piece.position = position;
	}
	
	/**
	 * @param position remove a peça da posição após movimentar
	 * @return retorna a peça retirada
	 */
	public Piece removePiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board!");
		}
		if (piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColunm()] = null;
		return aux;
	}

	/**
	 * @method Método auxiliar
	 * @return verifica pela linha e pela coluna se existe ou não existe uma posição
	 */
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	/**
	 * @return verifica se existe ou não existe uma posição
	 */
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColunm());
	}

	/**
	 * @return verifica se tem uma peça na posição
	 */
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board!");
		}
		return piece(position) != null;
	}

}
