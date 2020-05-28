package club.banyuan.machine;

import static club.banyuan.machine.FlowStatus.*;

import club.banyuan.menu.Menu;
import club.banyuan.menu.MenuNode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class VendingMachine implements Serializable {

  public static final int SHELVES_NUM = 5;
  public static final String NO_PURCHASE = "=";
  public static final String PRODUCT_SELL_OUT = "X";
  public static final String PRODUCT_AVAILABLE = "O";
  public static final String PRODUCT_DEFAULT = " ";
  public static final int FULL_INVENTORY = 10;


  private Menu menu;
  private static final int password = 1110;

  private int userAmount;
  private int salesAmount;
  private String purchasedProduct = NO_PURCHASE;
  private Shelf[] shelves = new Shelf[SHELVES_NUM];

  private FlowStatus flowStatus = ROOT;

  {
    /*
    初始化产品列表
    A. Juice ($10) (5 left)
    B. Cola($6)(1left)
    C. Tea ($5) (2 left)
    D. Water ($8) (1 left)
    E. Coffee ($7) (9 left)
     */
    shelves[0] = new Shelf("A", "Juice", 10, 5);
    shelves[1] = new Shelf("B", "Cola", 6, 1);
    shelves[2] = new Shelf("C", "Tea", 5, 2);
    shelves[3] = new Shelf("D", "Water", 8, 1);
    shelves[4] = new Shelf("E", "Coffee", 7, 9);
  }


  public String displayShevles() {
    StringBuilder stringBuilder = new StringBuilder();
    buildLogoDisplay(stringBuilder);
    buildShelvesDisplay(stringBuilder);
    buildBottomDisplay(stringBuilder);
    System.out.println(stringBuilder.toString());
    System.out.println();
    return stringBuilder.toString();
  }

  private void buildBottomDisplay(StringBuilder stringBuilder) {
    stringBuilder.append("*---------------------------*").append(System.lineSeparator());
    stringBuilder.append(String.format("|                    [$%2s]  |", userAmount))
        .append(System.lineSeparator());
    stringBuilder.append("|                           |").append(System.lineSeparator());
    stringBuilder.append(String.format("|           [=%s=]           |", purchasedProduct))
        .append(System.lineSeparator());
    stringBuilder.append("*---------------------------*");
  }

  private void buildLogoDisplay(StringBuilder stringBuilder) {
    stringBuilder
        .append("*---------------------------*").append(System.lineSeparator())
        .append("|     Vending   Machine     |").append(System.lineSeparator())
        .append("*---------------------------*").append(System.lineSeparator());
  }

  private void buildShelvesDisplay(StringBuilder stringBuilder) {

    String[] codeTemplate = new String[SHELVES_NUM];
    int[] priceTemplate = new int[SHELVES_NUM];
    String[] inventoryTemplate = new String[SHELVES_NUM];

    for (int i = 0; i < shelves.length; i++) {
      codeTemplate[i] = shelves[i].getCode();
      priceTemplate[i] = shelves[i].getPrice();
      // 如果用户投币的金额如果小于 产品的金额，不显示内容。
      // 如果用户投币的金额大于产品金额，显示O
      // 如果产品库存为0，显示X
      inventoryTemplate[i] = shelves[i].getInventory() == 0 ? PRODUCT_SELL_OUT
          : (shelves[i].getPrice() <= userAmount ? PRODUCT_AVAILABLE : PRODUCT_DEFAULT);
    }

    stringBuilder.append(String
        .format("|   %s    %s    %s    %s    %s   |", codeTemplate[0], codeTemplate[1],
            codeTemplate[2], codeTemplate[3], codeTemplate[4])).append(System.lineSeparator());

    stringBuilder.append(String
        .format("|  $%2s  $%2s  $%2s  $%2s  $%2s  |", priceTemplate[0], priceTemplate[1],
            priceTemplate[2], priceTemplate[3], priceTemplate[4])).append(System.lineSeparator());
    stringBuilder.append(String
        .format("|  [%s]  [%s]  [%s]  [%s]  [%s]  |", inventoryTemplate[0], inventoryTemplate[1],
            inventoryTemplate[2], inventoryTemplate[3], inventoryTemplate[4]))
        .append(System.lineSeparator());
  }

  public void start() {
    displayShevles();
    String userInput;
    while (true) {
      switch (flowStatus) {
        case ROOT:
          displayRootMenu();
          userInput = scanUserInput(
              getInputPredicate(Arrays.asList("1", "2", "3", "4", "0", "9")), t -> displayRootMenu()
          );
          flowStatus = changeMenuFromRoot(userInput);
          break;
        case READ_PRODUCT_INFO:
          displayProductInfo();
          flowStatus = ROOT;
          break;
        case INSERT_COIN:
          displayInsertCoinMenu();
          userInput = scanUserInput(
              getInputPredicate(4),
              t -> displayInsertCoinMenu()
          );
          flowStatus = changeMenuFromInsertCoin(userInput);
          break;
        case PRESS_PRODUCT_BTN:
          displayShevles();
          displayPressProductBtn();
          userInput = scanUserInput(
              getInputPredicate(shelves.length),
              t -> displayInsertCoinMenu()
          );
          flowStatus = changeMenuFromPressProductBtn(userInput);
          break;
        case PRESS_RETURN_BTN:
          returnUserAmount();
          displayShevles();
          flowStatus = ROOT;
          break;
        case OPEN_SERVICE_MENU:
          flowStatus = authentication();
          if (flowStatus == ROOT) {
            displayShevles();
          }
          break;
        case ADMIN_ROOT:
          displayAdminRootMenu();
          userInput = scanUserInput(getInputPredicate(4), t -> displayAdminRootMenu());
          flowStatus = changeMenuFromAdminRoot(userInput);
          break;
        case ADMIN_INSPECT_STATUS:
          displayMachineStatus();
          flowStatus = ADMIN_ROOT;
          break;
        case ADMIN_WITHDRAW_MONEY:
          withdrawMoney();
          flowStatus = ADMIN_ROOT;
          break;
        case ADMIN_REFILL_PRODUCT:
          displayRefileProduct();
          userInput = scanUserInput(getInputPredicate(shelves.length), t -> displayRefileProduct());
          refillProduct(userInput);
          flowStatus = ADMIN_ROOT;
          break;
        case ADMIN_CHANGE_PRODUCT:
          displayChangingProduct();
          userInput = scanUserInput(getInputPredicate(shelves.length),
              t -> displayChangingProduct());
          changeProduct(userInput);
          flowStatus = ADMIN_ROOT;
          break;
        case QUIT:
          System.exit(0);
      }
    }


  }

  private void changeProduct(String userInput) {
    int index = Integer.parseInt(userInput);
    if (index - 1 >= 0) {
      Shelf shelf = shelves[index - 1];
      Scanner scanner = new Scanner(System.in);
      System.out.printf("You are changing product %s.\n", shelf.getCode());
      System.out.printf("Enter new product name:");
      String name = scanner.next();
      int price = 0;
      try {
        System.out.printf("Enter new product price:");
        price = scanner.nextInt();
      } catch (Exception e) {
        System.out.println("Invalid input");
        changeProduct(userInput);
        return;
      }
      shelf.setName(name);
      shelf.setPrice(price);
      shelf.setInventory(FULL_INVENTORY);
      System.out.printf("The new product %s has been filled to full.\n", shelf.getCode());
    }
  }

  private void displayChangingProduct() {
    System.out.println("(4-4) Which product would you like to change?");
    displayShelvesAsMenu();
  }

  private void refillProduct(String userInput) {
    int index = Integer.parseInt(userInput);
    if (index - 1 >= 0) {
      Shelf refileShelf = shelves[index - 1];
      System.out.printf("You have refilled product %s to full.\n", refileShelf.getCode());
      refileShelf.setInventory(FULL_INVENTORY);
    }
  }

  private void displayRefileProduct() {
    System.out.println("(9-3) Which product would you like to refill?");
    displayShelvesAsMenu();
  }

  private void displayShelvesAsMenu() {
    for (int i = 0; i < shelves.length; i++) {
      System.out.printf("%d. %s\n", i + 1, shelves[i].getCode());
    }
    System.out.println("0. Go back");
  }

  private void withdrawMoney() {
    System.out.println("(9-2) All money is being withdrawn.");
    System.out.printf("$%s is withdrawn.\n", salesAmount);
    salesAmount = 0;
  }

  /**
   * (9-1) Machine status
   * Amount of revenue: $6
   * Amount of inserted coins: $0
   * A. Juice ($10) (5 left)
   * B. Cola ($6) (sold out)
   * C. Tea ($5) (2 left)
   * D. Water ($8) (1 left)
   * E. Coffee ($7) (9 left)
   */
  private void displayMachineStatus() {
    System.out.println("(9-1) Machine status");
    System.out.printf("Amount of revenue: $%s\n", salesAmount);
    System.out.printf("Amount of inserted coins: $%s\n", userAmount);
    for (Shelf shelf : shelves) {
      int inventory = shelf.getInventory();
      String inventoryLeft = inventory == 0 ? "sold out" : inventory + " left";
      System.out.printf("%s. %s ($%s) (%s)\n", shelf.getCode(), shelf.getName(), shelf.getPrice(),
          inventoryLeft);
    }
    System.out.println();
  }

  private FlowStatus changeMenuFromAdminRoot(String userInput) {
    switch (userInput) {
      case "1":
        return ADMIN_INSPECT_STATUS;
      case "2":
        return ADMIN_WITHDRAW_MONEY;
      case "3":
        return ADMIN_REFILL_PRODUCT;
      case "4":
        return ADMIN_CHANGE_PRODUCT;
      case "0":
        return ROOT;
    }
    throw new VendingMachineException("user input invalid:" + userInput);
  }

  private void displayAdminRootMenu() {
    System.out.println("(9) What would you like to do?\n"
        + " 1. Inspect machine status\n"
        + " 2. Withdraw all money\n"
        + " 3. Refill product\n"
        + " 4. Change product\n"
        + " 0. Go back\n");
  }

  private FlowStatus authentication() {
    System.out.println("(9) Opening service menu. Access code is required.");
    System.out.print("Enter access code:");
    Scanner scanner = new Scanner(System.in);
    String userInput = scanner.next();

    try {
      if (Integer.parseInt(userInput) == password) {
        return ADMIN_ROOT;
      }
    } catch (NumberFormatException e) {
      // 不做任何处理，保证程序运行
    }
    System.out.println("Incorrect code!");
    return ROOT;

    // + "Enter access code: 1234\n"
    // + "Incorrect code!");
  }

  private void returnUserAmount() {
    System.out.println("(4) Return button is pressed.");
    System.out.printf("$%s has been returned.\n", userAmount);
    userAmount = 0;
  }

  private FlowStatus changeMenuFromPressProductBtn(String userInput) {

    int index = Integer.parseInt(userInput);
    if (index == 0) {
      return ROOT;
    }
    Shelf purchase = shelves[index - 1];
    System.out.printf("You have pressed button %s.\n", purchase.getCode());
    if (purchaseProduct(purchase)) {
      return ROOT;
    } else {
      System.out.println("invalid choice");
      return PRESS_PRODUCT_BTN;
    }
  }

  private boolean purchaseProduct(Shelf purchase) {
    if (purchase.getInventory() > 0 && userAmount >= purchase.getPrice()) {
      userAmount -= purchase.getPrice();
      salesAmount += purchase.getPrice();
      purchase.setInventory(purchase.getInventory() - 1);
      purchasedProduct = purchase.getCode();
      displayShevles();
      purchasedProduct = NO_PURCHASE;
      return true;
    } else {
      return false;
    }
  }

  private Predicate<String> getInputPredicate(List<String> strings) {
    return strings::contains;
  }

  private Predicate<String> getInputPredicate(int to) {
    return s -> {
      int inputInt = 0;
      try {
        inputInt = Integer.parseInt(s);
      } catch (NumberFormatException e) {
        return false;
      }
      return inputInt >= 0 && inputInt <= to;
    };
  }

  private void displayPressProductBtn() {
    System.out.println("(3) Which product button would you like to press?\n");
    displayShelvesAsMenu();
  }

  private FlowStatus changeMenuFromInsertCoin(String userInput) {
    int amount = 0;
    switch (userInput) {
      case "1":
        amount += 1;
        break;
      case "2":
        amount += 2;
        break;
      case "3":
        amount += 5;
        break;
      case "4":
        amount += 10;
        break;
      case "0":
        System.out.println("Going back!\n");
        return ROOT;
    }
    userAmount += amount;
    System.out.printf("You have inserted $%s.\n\n", amount);
    displayShevles();
    return INSERT_COIN;
  }

  private void displayInsertCoinMenu() {
    System.out.println("(2) Which coin would you like to insert?\n"
        + " 1. $1\n"
        + " 2. $2\n"
        + " 3. $5\n"
        + " 4. $10\n"
        + " 0. Go back");
  }

  /**
   * (1) The displayed products are:
   * A. Juice ($10)
   * B. Cola ($6)
   * C. Tea ($5)
   * D. Water ($8)
   * E. Coffee ($7)
   */
  private void displayProductInfo() {
    System.out.println();
    System.out.println("(1) The displayed products are:");
    for (Shelf shelf : shelves) {
      System.out.printf("%s. %s ($%s)\n", shelf.getCode(), shelf.getName(), shelf.getPrice());
    }
    System.out.println();
  }

  private FlowStatus changeMenuFromRoot(String userInput) {
    switch (userInput) {
      case "1":
        return FlowStatus.READ_PRODUCT_INFO;
      case "2":
        return FlowStatus.INSERT_COIN;
      case "3":
        return FlowStatus.PRESS_PRODUCT_BTN;
      case "4":
        return FlowStatus.PRESS_RETURN_BTN;
      case "9":
        return FlowStatus.OPEN_SERVICE_MENU;
      case "0":
        return FlowStatus.QUIT;
      default:
        throw new VendingMachineException("user input invalid:" + userInput);
    }
  }

  private void displayRootMenu() {
    System.out.println("What would you like to do?\n"
        + " 1. Read product information\n"
        + " 2. Insert coin\n"
        + " 3. Press product button\n"
        + " 4. Press return button\n"
        + " 9. Open service menu (code required)\n"
        + " 0. Quit\n");
  }

  private String scanUserInput(Predicate<String> inputValidate,
      Consumer<String> displayDuringInputWrong) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Your choice:");
    String userInput = scanner.next();
    boolean testResult = inputValidate.test(userInput);
    if (!testResult) {
      System.out.println("Invalid choice!");
      System.out.println();
      if (displayDuringInputWrong != null) {
        displayDuringInputWrong.accept(userInput);
      }
      userInput = scanUserInput(inputValidate, displayDuringInputWrong);
    }
    return userInput;
    // int rlt;
    // try {
    //   rlt = Integer.parseInt(scanner.next());
    // } catch (NumberFormatException e) {
    //   System.out.println("invalid choice");
    //   // 用户定制的方法
    //   doSomething();
    //   rlt = scanUserInput();
    // }
    // return rlt;
  }


  // public void initMenu() {
  //   menu = new Menu();
  //   MenuNode menuNode = new MenuNode();
  //   menu.setRoot(menuNode);
  //   List<MenuNode> subMenu = new ArrayList<>();
  //   subMenu.add(new MenuNode());
  //   subMenu.add(new MenuNode());
  //   subMenu.add(new MenuNode());
  //   subMenu.add(new MenuNode());
  //   menuNode.setSubMenus(subMenu);
  //
  //   subMenu.get(1).setSubMenus();
  // }
}
