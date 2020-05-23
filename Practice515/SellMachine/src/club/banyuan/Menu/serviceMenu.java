package club.banyuan.Menu;

import club.banyuan.Exception.SetInputException;
import club.banyuan.Machine.Machine;
import club.banyuan.Machine.ProductStore;
import java.util.Scanner;


public class serviceMenu {

  //管理层菜单
  private String Key;

  public serviceMenu() {
    initKey();
  }

  private void initKey() {
    this.Key = "1110";
  }

  private boolean isCorrectKey(String input) {
    return Key.equals(input);
  }

  public void JudgeCode(String input) throws SetInputException {
    if (isCorrectKey(input)) {
    } else {
      throw new SetInputException("incorrect code!");
    }
  }

  public void showServiceMenu() {
    System.out.println();
    System.out.print("(9) What would you like to do?\n" +
        "1. Inspect machine status\n" +
        "2. Withdraw all money\n" +
        "3. Refill product\n" +
        "4. Change product\n");
  }

  //1-9-1 Inspect machine status
  public void Inspect(Machine machine) {
    System.out.println();
    System.out.println("(9-1) Machine status:");
    System.out.println("Amount of revenue:" + machine.getRevenue());
    System.out.println("Amount of inserted coins: " + machine.getMoneyLeft());
    for (int i = 0; i < machine.getProductNum(); i++) {
      ProductStore product = machine.selectProduct(i + 1);
      if (product.getNum() != 0) {
        System.out.println(
            product.getOption() + "." + product.getName() + "($" + product.getPrice() + ")" + " ("
                + product.getNum() + ")");
      } else {
        System.out.println(
            product.getOption() + "." + product.getName() + "($" + product.getPrice() + ")"
                + "(sold out)");
      }
    }
    System.out.println();
  }

  //1-9-2 withdraw allMoney
  public void withdraw(Machine machine) {
    System.out.println();
    System.out.println("(9-2) All money is being withdrawn.\n" +
        "$" + machine.withdrawMoney() + "is withdrawn.");
  }

  //1-9-3
  public void refill(Machine machine, int ChoiceForRefill) {
    System.out.println();
    machine.selectProduct(ChoiceForRefill).setNum(10);
    System.out.println(
        "You have refilled product " + machine.selectProduct(ChoiceForRefill).getOption()
            + " to full.");
  }

  //1-9-4-1. Changing product
  public void changeProduct(Machine machine, int choiceForChange) {
    try {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter new product name:");
      String name = scanner.nextLine();
      machine.selectProduct(choiceForChange).setName(name);
      System.out.println("Enter new product price:");
      machine.selectProduct(choiceForChange).setPrice(scanner.nextInt());
    } catch (SetInputException e) {
      System.out.println("invalid input!");
    }


  }


}
