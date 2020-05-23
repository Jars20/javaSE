package club.banyuan.Exception;

public class GoBackException extends Exception{

  public GoBackException() {
  }

  public GoBackException(String message) {
    super(message);
  }

  public GoBackException(String message, Throwable cause) {
    super(message, cause);
  }

  public GoBackException(Throwable cause) {
    super(cause);
  }

  protected GoBackException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
