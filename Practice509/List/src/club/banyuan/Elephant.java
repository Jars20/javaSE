package club.banyuan;

import club.banyuan.util.Comparable;
import java.util.Objects;

public class Elephant implements Comparable {

  public int heightInCM;

  public Elephant() {
  }

  public Elephant(int heightInCM) {
    this.heightInCM = heightInCM;
  }

  private static Elephant[] cache = new Elephant[10];
  private static int cacheSize = 0;

  public static Elephant valueOf(int heightInCM) {
    for (Elephant elephant : cache) {
      if (elephant == null) {
        break;
      }
      if (elephant.heightInCM == heightInCM) {
        return elephant;
      }
    }
    Elephant elephant = new Elephant(heightInCM);
    cache[cacheSize++] = elephant;
    return elephant;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Elephant elephant = (Elephant) o;
    return heightInCM == elephant.heightInCM;
  }

  @Override
  public int hashCode() {
    return Objects.hash(heightInCM);
  }

  public static void main(String[] args) {
    Elephant elephant = new Elephant();
    Elephant elephant1 = new Elephant();

    System.out.println(elephant == elephant1);

    Elephant elephant2 = Elephant.valueOf(200);
    Elephant elephant3 = Elephant.valueOf(200);
    System.out.println(elephant2 == elephant3);

  }

  @Override
  public int compareTo(Comparable c) {
    if (c instanceof Elephant) {
      Elephant elephant = (Elephant) c;
      return Integer.compare(this.heightInCM, elephant.heightInCM);
    } else {
      System.out.println("类型不匹配");
      return 0;
    }
  }

  @Override
  public String toString() {
    return "Elephant{" +
        "heightInCM=" + heightInCM +
        '}';
  }
}