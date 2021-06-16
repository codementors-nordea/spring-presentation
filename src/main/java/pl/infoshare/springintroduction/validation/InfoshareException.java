package pl.infoshare.springintroduction.validation;

public abstract class InfoshareException extends RuntimeException {

    private final String errorCode;

    public InfoshareException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
