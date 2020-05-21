package club.banyuan;

import club.banyuan.machine.Fridge;

public interface PutInElephant {

  void putElephant(Fridge fridge, Elephant elephant);

  public static void main(String[] args) {
    // lambda中如果存在实例A调用方法，实例B作为入参，可以使用方法引用的方式，实现方法的第一个参数作为调用方，第二个参数作为调用方法的传入参数。
    PutInElephant putInElephant = Fridge::setAnimal;

    // PutInElephant putInElephant = (elephant, fridge) -> fridge.setAnimal(elephant);
  }
}
