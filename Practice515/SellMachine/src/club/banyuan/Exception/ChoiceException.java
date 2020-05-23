package club.banyuan.Exception;

public class ChoiceException extends Exception{
    public ChoiceException() {
        super();
    }

    public ChoiceException(String message) {
        super(message);
    }

    public ChoiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChoiceException(Throwable cause) {
        super(cause);
    }

    protected ChoiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
