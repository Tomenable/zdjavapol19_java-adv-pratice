package pl.sda.zdjavapol19.throwing;

public class ContainsDigitsValidator extends ContainsCharsValidator {

    public ContainsDigitsValidator() {
        super(unicodesToCharsRange(48, 57));
    }

}
