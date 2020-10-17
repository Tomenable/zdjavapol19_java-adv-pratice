package pl.sda.zdjavapol19.throwing;

public abstract class Validator {

    protected final String req;

    protected Validator(String req) {
        this.req = req;
    }

    public String getReq() {
        return this.req;
    }

    public abstract boolean isValid(String pswd) throws ValidationException;

}
