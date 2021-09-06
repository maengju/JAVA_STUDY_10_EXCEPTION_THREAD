package exception;

public class MakeException extends Exception { // 개발자가 만든 Exception 클래스
	private String errorMessage;
	
	
	public MakeException() {

	}

	public MakeException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
	@Override
	public String toString() {
		return getClass() + ":" + errorMessage;
	}
}
