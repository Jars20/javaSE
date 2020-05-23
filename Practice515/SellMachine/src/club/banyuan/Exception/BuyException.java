package club.banyuan.Exception;

public class BuyException extends Exception {
    public BuyException() {
    }

    public BuyException(String message) {
        super(message);
    }

    public BuyException(String message, Throwable cause) {
        super(message, cause);
    }

    public BuyException(Throwable cause) {
        super(cause);
    }

    public BuyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
