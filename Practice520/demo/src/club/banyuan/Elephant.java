package club.banyuan;

import java.util.Objects;

public class Elephant implements Comparable<Elephant> {

  private int height;

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public Elephant(int height) {
    this.height = height;
  }

  @Override
  public String toString() {
    return "Elephant{" +
        "height=" + height +
        '}';
  }

  @Override
  public int compareTo(Elephant o) {
    return this.height - o.height;
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
    return height == elephant.height;
  }

  @Override
  public int hashCode() {
    return Objects.hash(height);
  }
}
