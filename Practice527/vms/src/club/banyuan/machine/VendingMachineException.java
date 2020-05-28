package club.banyuan.machine;

public class VendingMachineException extends RuntimeException {

  public VendingMachineException() {
  }

  public VendingMachineException(String message) {
    super(message);
  }

  public VendingMachineException(String message, Throwable cause) {
    super(message, cause);
  }

  public VendingMachineException(Throwable cause) {
    super(cause);
  }

  public VendingMachineException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
