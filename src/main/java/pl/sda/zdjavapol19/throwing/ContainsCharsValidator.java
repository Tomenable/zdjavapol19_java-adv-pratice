package pl.sda.zdjavapol19.throwing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ContainsCharsValidator extends Validator {

    protected final List<Integer> expectedChars;    //kod liczbowy znaku

        public ContainsCharsValidator(char[] expectedChars) {   //! @ # $ % ^ & * ...
        super("Hasło musi zawierać jeden ze znaków: " + Arrays.toString(expectedChars));
        this.expectedChars = new String(expectedChars)
                .chars()
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(String pswd) throws ValidationException {
        if(pswd.chars().anyMatch(expectedChars::contains))
            return true;
        else
            throw new ContainsCharsValidationException(expectedChars);

    }

    //inclusive - ostatni podany znak wchodzi w sklad zwroconej tablicy
    protected static char[] unicodesToCharsRange(int uBegin, int uEndInclusive) {
        char[] chars = new char[uEndInclusive - uBegin + 1];
        for(int i = uBegin; i <= uEndInclusive; i++)
            chars[i-uBegin] = (char) i;

        return chars;
    }

    protected static char[] unicodesToChars(int[] unicodes) {
        char[] chars = new char[unicodes.length];
        for(int i = 0; i < unicodes.length; i++)
            chars[i] = (char) unicodes[i];

        return chars;
    }

    public class ContainsCharsValidationException extends ValidationException {
        public ContainsCharsValidationException(List<Integer> expectedChars) {
            super("Błąd walidacji: hasło musi zawierać jeden ze znaków: " +
                    Arrays.toString(
                            expectedChars.stream()
                                    .map(unicode -> (char) unicode.intValue())
                                    .collect(Collectors.toList())
                            .toArray()));
        }
    }
}
