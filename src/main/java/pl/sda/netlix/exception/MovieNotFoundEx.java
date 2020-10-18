package pl.sda.netlix.exception;

public class MovieNotFoundEx extends RuntimeException {

    public MovieNotFoundEx(String title) {
        super("Movie not found: " + title);
    }
}
