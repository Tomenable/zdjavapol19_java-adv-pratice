package pl.sda.zdjavapol19.throwing;

public class ContainsLargeLettersValidator extends ContainsCharsValidator {

    public ContainsLargeLettersValidator() {
        super(unicodesToCharsRange(65, 95));
    }

}
