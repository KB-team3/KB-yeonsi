package exception;

public class RangeWrongException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	public RangeWrongException() {}
	public RangeWrongException(String message) {
		super(message);
	}


}
