package club.banyuan.Menu;

import club.banyuan.Exception.ChoiceException;
import club.banyuan.Exception.GoBackException;
import club.banyuan.Exception.SetInputException;
import club.banyuan.Machine.Coins;
import club.banyuan.Machine.Machine;
import java.util.Scanner;

public class ShowMenu {

  //展示商品菜单
  public static void displayProducts(Machine machine) {
    System.out.println("(1) The displayed products are: ");
    machine.displayProduct();
  }


  //二级菜单1.2,投币
  public static void InsertCoin(Machine machine) throws GoBackException {
    while (true) {
      System.out.print("(2) Which coin would you like to insert?\n" +
          "1. $1\n" +
          "2. $2\n" +
          "3. $5\n" +
          "4. $10\n");
      try {
        Scanner sc = new Scanner(System.in);
        int choice = backAndChoice(Coins.values().length);
        for (Coins coin : Coins.values()) {
          if (coin.ordinal() == choice - 1) {
            machine.insertCoin(coin);
            System.out.println("You have inserted $" + coin.getWorth());
          }

        }

      } catch (GoBackException e) {
        throw e;
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
      System.out.println();
      return;
    }//while
  }


  //二级菜单1-3,choice product
  public static void ChoiceProduct(Machine machine) throws GoBackException {
    System.out.println("Which product button would you like to press?");
    for (int i = 0; i < machine.getProductNum(); i++) {
      System.out.println("" + (i + 1) + ". " + machine.selectProduct(i + 1).getOption());
    }
    try {
      int choice = backAndChoice(machine.getProductNum());
      System.out.println("You have pressed button " + machine.selectProduct(choice).getOption());
      machine.setBuyingProduct(machine.selectProduct(choice).getOption());
      machine.buyProduct(machine.selectProduct(choice));
    } catch (GoBackException e) {
      throw e;
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  // 一级菜单1-4
  public static void returnMoney(Machine machine) {
    System.out.println("\nReturn button is pressed");
    System.out.println("$" + machine.returnLefCoin() + " has been returned");
  }

  // 一级菜单1-9
  //进入管理层模式
  // 如果选择了选项9，则要求用户输入访问密码（默认值：1110）。输入错误密码，给与错误消息后，将返回售货机面板并显示主菜单。
  public static void administerSignIn(Machine machine) throws GoBackException, SetInputException {
    System.out.print("Access code is required.\n" +
        "Enter access code: \n");
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    serviceMenu Administer = new serviceMenu();
    Administer.JudgeCode(input);
//        输入错误密码后，返回mainmenu
//        System.out.println("incorrect code!");
    while (true) {
      Administer.showServiceMenu();
      try {
        int choice = backAndChoice(4);
        switch (choice) {
          case 1:
            Administer.Inspect(machine);
            break;
          case 2:
            Administer.withdraw(machine);
            break;
          case 3:
            System.out.println("(9-3) Which product would you like to refill?");
            for (int i = 0; i < machine.getProductNum(); i++) {
              System.out.println(i + 1 + "." + machine.selectProduct(i + 1).getOption());
            }
            int choiceForRefill = backAndChoice(machine.getProductNum());
            Administer.refill(machine, choiceForRefill);
            break;
          case 4:
            System.out.println("(4-4) Which product would you like to change?");
            for (int i = 0; i < machine.getProductNum(); i++) {
              System.out.println(i + 1 + "." + machine.selectProduct(i + 1).getOption());
            }
            int choiceForChange = backAndChoice(machine.getProductNum());
            Administer.changeProduct(machine, choiceForChange);
        }
      } catch (GoBackException e) {
        throw e;
      } catch (Exception ignored) {

      }
    }//while
  }


  public static int backAndChoice(int length) throws Exception {
    System.out.println("0. Go back");
    System.out.println();
    Scanner sc = new Scanner(System.in);
    System.out.print("Your choice:");
    try {
      int choice = sc.nextInt();
      if (choice > 0 && choice <= length) {
        return choice;
      } else if (choice == 0) {
        throw new GoBackException("Going back!");
      } else {
        throw new ChoiceException("Invalid choice!");
      }
    } catch (GoBackException | ChoiceException e) {
      throw e;
    } catch (Exception e) {
      System.out.println("Illegal input!");
      throw e;
    }
  }

  //打印可视化的machine
  public static void graphicMachine(Machine machine) {
    System.out.println("*-----------------------------*");
    System.out.println("|      Vending   Machine      |");
    System.out.println("*-----------------------------*");
    System.out.print("|");
    for (int i = 1; i <= machine.getProductNum(); i++) {
      System.out.printf("%5s", machine.selectProduct(i).getOption());
    }
    System.out.println("    |");
    //显示价格
    System.out.print("| ");
    for (int i = 1; i <= machine.getProductNum(); i++) {
      System.out.printf("  $%2d", machine.selectProduct(i).getPrice());
    }
    System.out.println("   |");
    //显示可否被购买
    System.out.print("| ");
    for (int i = 1; i <= machine.getProductNum(); i++) {
      machine.productStatus();
      if (machine.selectProduct(i).isEmpty()) {
        System.out.print("  [X]");
      } else {
        if (machine.selectProduct(i).isStatus()) {
          System.out.print("  [O]");
        } else {
          System.out.print("  [ ]");
        }
      }
    }
    System.out.println("   |");
    System.out.println("*-----------------------------*");
    //显示投币余额
    System.out.printf("|                     [$%2d]   |\n", machine.getMoneyLeft());
    System.out.println("|                             |");
    //显示当前购买的商品
    System.out.printf("|            [=%s=]            |\n", machine.getBuyingProduct());
    System.out.println("*-----------------------------*");
    System.out.println();
  }


}
