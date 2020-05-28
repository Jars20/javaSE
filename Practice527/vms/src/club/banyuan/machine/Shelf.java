package club.banyuan.machine;

import java.io.Serializable;

public class Shelf implements Serializable {

  private String code;
  private String name;
  private int price;
  private int inventory;

  // public Shelf() {
  //
  // }

  public Shelf(String code, String name, int price, int inventory) {
    this.price = price;
    this.inventory = inventory;
    this.code = code;
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getInventory() {
    return inventory;
  }

  public void setInventory(int inventory) {
    this.inventory = inventory;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
