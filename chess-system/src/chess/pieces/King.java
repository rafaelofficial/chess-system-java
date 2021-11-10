package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}

	/**
	 * Método auxiliar
	 * 
	 * @param position pega a peça na posição
	 * @return verifica se o Rei pode mover para uma determinada posição
	 */
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// above
		p.setValue(position.getRow() - 1, position.getColunm());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// below
		p.setValue(position.getRow() + 1, position.getColunm());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// left
		p.setValue(position.getRow(), position.getColunm() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// right
		p.setValue(position.getRow(), position.getColunm() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// nw
		p.setValue(position.getRow() - 1, position.getColunm() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// ne
		p.setValue(position.getRow() - 1, position.getColunm() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// sw
		p.setValue(position.getRow() + 1, position.getColunm() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		// se
		p.setValue(position.getRow() + 1, position.getColunm() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColunm()] = true;
		}

		return mat;
	}

}
