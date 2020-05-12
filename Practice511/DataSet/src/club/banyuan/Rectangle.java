package club.banyuan;

public class Rectangle implements Measurable {

  public int width;

  public int height;

  public Rectangle(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  @Override
  public String toString() {
    return "Rectangle{" +
        "width=" + width +
        ", height=" + height +
        '}';
  }

  @Override
  public double getMeasure() {
    return  width*height/2;
  }
}