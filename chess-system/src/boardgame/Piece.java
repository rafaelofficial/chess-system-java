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
	 * @return movimentos poss�veis
	 */
	public abstract boolean[][] possibleMoves();

	/**
	 * ## Hook Method
	 * 
	 * @param position
	 * @return retorna se � poss�vel mover a pe�a para dada a posi��o
	 */
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColunm()];
	}

	/**
	 * @return verifica se existe pelo menos um movimento poss�vel para mover a pe�a
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
