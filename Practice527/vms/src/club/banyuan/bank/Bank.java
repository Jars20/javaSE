package club.banyuan.bank;

import club.banyuan.menu.Menu;
import club.banyuan.menu.MenuFlow;
import club.banyuan.menu.MenuNode;
import club.banyuan.menu.MenuType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bank implements MenuFlow<BankFlow> {

  private Menu<BankFlow> menu;

  public void initMenu() {
    List<MenuNode<BankFlow>> menuNodes = Arrays.asList(
        new MenuNode<BankFlow>(null, null, "请输入", BankFlow.ROOT, null, MenuType.ROOT),
        new MenuNode<BankFlow>("1. 取款", "1", null, BankFlow.WITHDRAW_MONEY, BankFlow.ROOT,
            MenuType.SINGLE),
        new MenuNode<BankFlow>("2. 存款", "2", null, BankFlow.SAVE_MONEY, BankFlow.ROOT,
            MenuType.SINGLE)
    );

    menu = new Menu<>(menuNodes);
  }

  public static void main(String[] args) {
    // Bank bank = new Bank();
    // bank.initMenu();
    // bank.menu.display();
    // bank.menu.scanUserInput();

    Bank bank = new Bank();
    bank.visit(new Customer("张三"), new Customer("李四"), new Customer("王五"));
    bank.visit(new Customer("张三"));
    bank.visit();
    bank.visit(new Customer[]{new Customer("张三")});
    List<Customer> customers = new ArrayList<>();
  }

  @Override
  public void setFlowStatus(BankFlow flowStatus) {

  }

  // Customer[] customer;
  public void visit(Customer... customer) {
    System.out.println("来访客户数量:" + customer.length);
    for (Customer one : customer) {
      System.out.println(one.getName() + "visit");
    }
  }

  public void visit(Object customer) {
    // System.out.println("来访客户数量:" + customer.length);
    // for (Customer one : customer) {
    //   System.out.println(one.getName() + "visit");
    // }
  }

  public void visit(Customer customer) {
    // System.out.println("来访客户数量:" + customer.length);
    // for (Customer one : customer) {
    //   System.out.println(one.getName() + "visit");
    // }
  }
}
