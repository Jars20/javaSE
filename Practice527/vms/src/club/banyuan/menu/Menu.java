package club.banyuan.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Menu<T extends Enum<T>> {

  private MenuNode<T> root;
  private MenuNode<T> curNode;
  private MenuFlow<T> menuFlow;
  private final List<MenuNode<T>> allNodes = new ArrayList<>();

  public Menu(List<MenuNode<T>> allNodes) {
    for (MenuNode<T> allNode : allNodes) {
      addMenuNode(allNode);
    }
    if (root == null) {
      throw new IllegalArgumentException("没有根节点");
    }
    curNode = root;
  }

  public MenuFlow<T> getMenuFlow() {
    return menuFlow;
  }

  public void setMenuFlow(MenuFlow<T> menuFlow) {
    this.menuFlow = menuFlow;
  }

  public void addMenuNode(MenuNode<T> menuNode) {
    if (menuNode.getMenuType() == MenuType.ROOT) {
      if (root != null) {
        throw new IllegalArgumentException("已经存在根节点");
      }
      root = menuNode;
    }
    allNodes.forEach(t -> {
      if (t.getFlowStatus() == menuNode.getParentStatus()) {
        t.addSubMenu(menuNode);
      }

      if (t.getParentStatus() == menuNode.getFlowStatus()) {
        menuNode.addSubMenu(t);
      }
    });
    allNodes.add(menuNode);
  }

  public void display() {
    System.out.println(curNode.getTitle());
    if (curNode.getSubMenus() == null) {
      return;
    }
    for (MenuNode<T> subMenu : curNode.getSubMenus()) {
      System.out.println(subMenu.getDesc());
    }
  }

  public MenuNode<T> scanUserInput() {
    Scanner scanner = new Scanner(System.in);
    System.out.println();
    System.out.print("Your choice: ");
    String userInput = scanner.next();
    Optional<MenuNode<T>> selectNode = curNode.getSubMenus().stream()
        .filter(t -> t.getInputMatches().equals(userInput)).findFirst();

    if (selectNode.isPresent()) {
      return selectNode.get();
    } else {
      System.out.println("Invalid choice!");
      System.out.println();
      display();
      return scanUserInput();
    }
  }

  public void toNextMenu(T flowStatus) {
    Optional<MenuNode<T>> nextMenu = allNodes.stream().filter(t -> t.getFlowStatus() == flowStatus)
        .findFirst();
    if (nextMenu.isPresent()) {
      curNode = nextMenu.get();
    } else {
      throw new IllegalArgumentException("状态不存在:" + flowStatus);
    }
  }

  public T back() {
    curNode = curNode.getParentNode();
    if (menuFlow != null) {
      menuFlow.setFlowStatus(curNode.getFlowStatus());
    }
    return curNode.getFlowStatus();
  }
}
