package club.banyuan.Machine;

import club.banyuan.Exception.SetInputException;

public class ProductStore {                         //五个商品格子中的属性

  private String name;                            //商品名称，Juice，Cola，Tea，Water，Coffee
  private int price;                              //价格
  private int num;                                //存货量
  private final String option;                      //选项，ABCDE
  private boolean status;                         //可否购买


  public ProductStore(String option, String name, int price, int num) {
    this.option = option;
    this.name = name;
    this.price = price;
    this.num = num;
    this.status = false;
  }


  public String getOption() {
    return option;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) throws SetInputException {
    if (name.length() <= 20 && !name.contains(" ")) {
      this.name = name;
    } else {
      throw new SetInputException();
    }

  }

  public int getPrice() {
    return price;
  }


  public void setPrice(int price) throws SetInputException {
    if (price > 0 && price < 100) {
      this.price = price;
    } else {
      throw new SetInputException();
    }
  }

  public int getNum() {
    return num;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(int moneyLeft) {
    status = moneyLeft > price;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public boolean isEmpty() {
    return num == 0;
  }


  @Override
  public String toString() {
    return option + ". " + name + "($" + price + ")";
  }
}
