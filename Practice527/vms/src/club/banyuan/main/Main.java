package club.banyuan.main;

import club.banyuan.machine.VendingMachine;
import club.banyuan.machine.VendingMachineWithMenu;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main implements Serializable {

  public static void main(String[] args) {
    VendingMachineWithMenu vendingMachineWithMenu = new VendingMachineWithMenu();
    vendingMachineWithMenu.start();
  }


}
