package club.banyuan.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuNode<T extends Enum<T>> {

  private String title;
  private String inputMatches;
  private String desc;
  private T flowStatus;
  private T parentStatus;
  private MenuType menuType;
  private MenuNode<T> parentNode;
  private List<MenuNode<T>> subMenus;

  public MenuNode(String desc, String inputMatches, String title,
      T flowStatus, T parentStatus, MenuType menuType) {
    this.title = title;
    this.inputMatches = inputMatches;
    this.desc = desc;
    this.flowStatus = flowStatus;
    this.parentStatus = parentStatus;
    this.menuType = menuType;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getInputMatches() {
    return inputMatches;
  }

  public void setInputMatches(String inputMatches) {
    this.inputMatches = inputMatches;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public List<MenuNode<T>> getSubMenus() {
    return subMenus;
  }

  public void setSubMenus(List<MenuNode<T>> subMenus) {
    this.subMenus = subMenus;
  }

  public T getFlowStatus() {
    return flowStatus;
  }

  public void setFlowStatus(T flowStatus) {
    this.flowStatus = flowStatus;
  }

  public T getParentStatus() {
    return parentStatus;
  }

  public void setParentStatus(T parentStatus) {
    this.parentStatus = parentStatus;
  }

  public MenuType getMenuType() {
    return menuType;
  }

  public void setMenuType(MenuType menuType) {
    this.menuType = menuType;
  }

  public MenuNode<T> getParentNode() {
    return parentNode;
  }

  public void setParentNode(MenuNode<T> parentNode) {
    this.parentNode = parentNode;
  }

  public void addSubMenu(MenuNode<T> menuNode) {
    if (subMenus == null) {
      subMenus = new ArrayList<>();
    }

    subMenus.add(menuNode);
    menuNode.setParentNode(this);
  }
}
