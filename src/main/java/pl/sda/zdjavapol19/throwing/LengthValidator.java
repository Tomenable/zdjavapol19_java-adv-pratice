package pl.sda.zdjavapol19.throwing;

public class LengthValidator extends Validator {

    private final int expectedLength;

    public LengthValidator(int expectedLength) {
        super(String.format("Hasło musi mieć co najmniej %d znaków", expectedLength));
        this.expectedLength = expectedLength;
    }

    @Override
    public boolean isValid(String pswd) throws LengthValidationEx {
        if(pswd.length() < expectedLength)
            throw new LengthValidationEx(expectedLength);
        else
            return true;
    }

    public class LengthValidationEx extends ValidationException {

        public LengthValidationEx(int len) {
            super(String.format("Błąd walidacji: hasło musi mieć co najmniej %d znaków", len));
        }
    }
}
