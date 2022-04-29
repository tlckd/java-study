package exception;

public class MyException extends Exception {

	public MyException() {
		super("MyExcepion Occurs");
	}
	public MyException(String message) {
		super(message);
	}
	
}
