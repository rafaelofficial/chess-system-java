package boardgame;

public class BoardException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * @param message repassa uma mensagem para a superclasse RuntimeException
	 */
	public BoardException(String message) {
		super(message);
	}
}
