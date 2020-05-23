package club.banyuan.Exception;

public class SetInputException extends Exception {
    public SetInputException() {
        super();
    }

    public SetInputException(String message) {
        super(message);
    }

    public SetInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public SetInputException(Throwable cause) {
        super(cause);
    }

    protected SetInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
