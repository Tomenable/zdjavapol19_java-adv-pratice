package pl.sda.zdjavapol19.throwing;

public class ContainsLargeLettersValidator extends ContainsCharsValidator {

    private static char[] largeLetters;

    //todo refactor uwspolnienie metody dla wszystkich ContainsCharsValidator
    static {
        largeLetters = new char[90-65+1];
        for(int i = 65; i <= 90; i++)
            largeLetters[i-65] = (char) i;
    }

    public ContainsLargeLettersValidator() {
        super(largeLetters);
    }

}
