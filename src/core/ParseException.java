package core;

public class ParseException extends Exception {
    public final String failurePoint;

    public ParseException(String failurePoint, String message) {
        super(message);
        this.failurePoint = failurePoint;
    }
}
