package boardgame;

public abstract class Piece {

	protected Position position;
	private Board board;

	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() {
		return board;
	}

	/**
	 * @return movimentos possíveis
	 */
	public abstract boolean[][] possibleMoves();

	/**
	 * ## Hook Method
	 * 
	 * @param position
	 * @return retorna se é possível mover a peça para dada a posição
	 */
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColunm()];
	}

	/**
	 * @return verifica se existe pelo menos um movimento possível para mover a peça
	 */
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

}
