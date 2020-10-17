package pl.sda.zdjavapol19.throwing;

public class ContainsDigitsValidator extends ContainsCharsValidator {

    private static char[] digits;

    static {
        digits = new char[10];
        for(int i = 48; i <= 57; i++)
            digits[i-48] = (char) i;
    }

    public ContainsDigitsValidator() {
        super(digits);
    }

}
