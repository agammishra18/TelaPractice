package telaPracticeAPIAutomation.Exceptions;

@SuppressWarnings("serial")
public class ApplicationException extends Exception{
	
	public ApplicationException(String errorMessage)
	{
		super(errorMessage);
	}

}
