package club.banyuan.machine;

import org.junit.Assert;

public class VendingMachineTest {

  @org.junit.Test
  public void display() {
    VendingMachine vendingMachine = new VendingMachine();
    Assert.assertEquals(
        "*---------------------------*" + System.lineSeparator()
            + "|     Vending   Machine     |" + System.lineSeparator()
            + "*---------------------------*" + System.lineSeparator()
            + "|   A    B    C    D    E   |" + System.lineSeparator()
            + "|  $10  $ 6  $ 5  $ 8  $ 7  |" + System.lineSeparator()
            + "|  [ ]  [ ]  [ ]  [ ]  [ ]  |" + System.lineSeparator()
            + "*---------------------------*" + System.lineSeparator()
            + "|                    [$ 0]  |" + System.lineSeparator()
            + "|                           |" + System.lineSeparator()
            + "|           [===]           |" + System.lineSeparator()
            + "*---------------------------*", vendingMachine.displayShevles());
  }
}