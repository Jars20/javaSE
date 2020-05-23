package club.banyuan.Machine;

import club.banyuan.Exception.BuyException;

public class Machine {

  private int moneyLeft;
  private int revenue;
  private String BuyingProduct;
  private final ProductStore[] products = new ProductStore[5];

  public Machine() {
    initMachine();
  }


  public void initMachine() {
    moneyLeft = 0;
    revenue = 0;
    BuyingProduct = "=";
    products[0] = new ProductStore("A", "Juice", 10, 5);
    products[1] = new ProductStore("B", "Cola", 6, 1);
    products[2] = new ProductStore("C", "Tea", 5, 2);
    products[3] = new ProductStore("D", "Water", 8, 1);
    products[4] = new ProductStore("E", "Coffee", 7, 9);

  }


  public void insertCoin(Coins coins) {
    moneyLeft += coins.getWorth();
  }

  public ProductStore selectProduct(int i) {
    if (i > 0 && i <= products.length) {
      return products[i - 1];
    }
    return null;
  }


  public int getProductNum() {
    return products.length;
  }

  public int getMoneyLeft() {
    return moneyLeft;
  }

  public void setMoneyLeft(int moneyLeft) {
    this.moneyLeft = moneyLeft;
  }

  public int getRevenue() {
    return revenue;
  }

  public void setRevenue(int revenue) {
    this.revenue = revenue;
  }

  public String getBuyingProduct() {
    return BuyingProduct;
  }

  public void setBuyingProduct(String buyingProduct) {
    BuyingProduct = buyingProduct;
  }


  public void initBuyingProduct() {
    BuyingProduct = "=";
  }



  public void displayProduct() {
    for (ProductStore product : products) {
      System.out.println(product);
    }
  }


  //提取所有的钱
  public int withdrawMoney() {
    int sum = moneyLeft + revenue;
    moneyLeft = 0;
    revenue = 0;
    return sum;
  }

  //退零钱
  public int returnLefCoin() {
    int temp = moneyLeft;
    moneyLeft = 0;
    return temp;
  }

  //显示商品可购买的情况
  public void productStatus() {
    for (ProductStore product : products) {
      product.setStatus(moneyLeft);
    }
  }

  //购买商品
  public void buyProduct(ProductStore product) throws BuyException {
    if (product.getNum() == 0) {
      throw new BuyException("This product is empty! ");
    } else if (product.getPrice() > moneyLeft) {
      throw new BuyException("Your Money is not enough!");
    } else {
      int temp = product.getNum();
      product.setNum(--temp);
      revenue += product.getPrice();
      moneyLeft -= product.getPrice();
    }

  }


}
