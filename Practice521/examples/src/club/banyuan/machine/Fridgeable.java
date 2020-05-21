package club.banyuan.machine;

public interface Fridgeable {

  default void frozen() {
    System.out.println("frozen default");
  }
}
