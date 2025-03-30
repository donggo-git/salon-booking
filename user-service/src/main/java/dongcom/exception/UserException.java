package dongcom.exception;

public class UserException extends RuntimeException { // Changed from Exception to RuntimeException
    public UserException(String message) {
        super(message);
        System.out.println("This is user Exception");
    }
}
