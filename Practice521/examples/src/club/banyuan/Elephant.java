package club.banyuan;

import club.banyuan.animal.Animal;
import club.banyuan.animal.AnimalType;

public class Elephant extends Animal implements Comparable<Elephant>
{

  private int height;

  public Elephant() {
  }

  public Elephant(int height) {
    this.height = height;
  }

  @Override
  public AnimalType getAnimalType() {
    return null;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  @Override
  public int compareTo(Elephant o) {
    return this.height - o.height;
  }

  @Override
  public String toString() {
    return "Elephant{" +
        "height=" + height +
        '}';
  }
}
