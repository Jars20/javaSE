package club.banyuan;

import club.banyuan.Machine.Machine;
import club.banyuan.Menu.TopMenu;

public class Main {

  public static void main(String[] args) {
    Machine machine = new Machine();
    TopMenu.mainMenu(machine);
  }
}
