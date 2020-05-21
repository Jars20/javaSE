package club.banyuan;

import club.banyuan.animal.Tiger;
import club.banyuan.machine.Fridge;

public interface PutInAnimalTriple {

  void putInAnimal(Fridge fridge, Elephant elephant, Tiger tiger);

  public static void main(String[] args) {
    // lambda只有一句话的时候，并且调用了实例方法作为返回，可以进行如下简化
    // 第一个参数作为setAnimal的调用方，后两个参数传递给了setAnimal中，必须要保证setAnimal参数列表和后面两个参数的参数列表一致
    PutInAnimalTriple putInAnimalTriple = Fridge::setAnimal;

    putInAnimalTriple.putInAnimal(new Fridge(500), new Elephant(), new Tiger());
  }
}
