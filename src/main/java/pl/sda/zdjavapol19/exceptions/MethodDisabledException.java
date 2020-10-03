package pl.sda.zdjavapol19.exceptions;

public class MethodDisabledException extends RuntimeException {

    public MethodDisabledException(String message) {
        super("This method was disabled. " + message);
    }
}
