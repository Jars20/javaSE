package club.banyuan;

public class ElephantNotComparable {

  private int height;

  public ElephantNotComparable(int height) {
    this.height = height;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  @Override
  public String toString() {
    return "ElephantNotComparable{" +
        "height=" + height +
        '}';
  }
}
