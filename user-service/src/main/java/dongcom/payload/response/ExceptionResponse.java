package dongcom.payload.response;

import java.time.LocalDate;

import org.springframework.cglib.core.Local;

public class ExceptionResponse {
    private String message;
    private String error;
    private LocalDate timestamp;

    public ExceptionResponse() {

    }

    public ExceptionResponse(String message, String error, LocalDate timestamp) {
        this.message = message;
        this.error = error;
        this.timestamp = timestamp;
    }

    void setMessage(String newMessage) {
        this.message = newMessage;
    }

    String getMessage() {
        return this.message;
    }

    void setError(String newError) {
        this.error = newError;
    }

    String getError() {
        return this.error;
    }

    void setTimeStamp(LocalDate newTimeStamp) {
        this.timestamp = newTimeStamp;
    }

    LocalDate getTimeStamp() {
        return this.timestamp;
    }

    @Override
    public String toString() {
        return "ExceptionResponse{" +
                "message='" + message + '\'' +
                ", details='" + error + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
