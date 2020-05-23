package club.banyuan.Menu;

import club.banyuan.Machine.Machine;
import java.util.Scanner;

public class TopMenu {

  //根目录
  public static void mainMenu(Machine machine) {
    machine.initBuyingProduct();
    while (true) {
      ShowMenu.graphicMachine(machine);
      System.out.println();
      System.out.println("What would you like to do?\n" +
          " 1. Read product information\n" +
          " 2. Insert coin\n" +
          " 3. Press product button\n" +
          " 4. Press return button\n" +
          " 9. Open service menu(code required)\n" +
          " 0. Quit");
      System.out.println("Your Choice:  ");
      Scanner sc = new Scanner(System.in);
      try {
        int choice = sc.nextInt();
        switch (choice) {
          case 1:
            ShowMenu.displayProducts(machine);
            break;
          case 2:
            ShowMenu.InsertCoin(machine);
            break;
          case 3:
            //choice products
            ShowMenu.ChoiceProduct(machine);
            break;
          case 4:
            // 退钱
            ShowMenu.returnMoney(machine);
            break;
          case 9:
            //service Menu
            ShowMenu.administerSignIn(machine);
            break;
          case 0:
            return;
          default:
            System.out.println("invalid choice!");
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
      System.out.println();
    }//while
  }

}
