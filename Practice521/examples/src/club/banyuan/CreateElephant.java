package club.banyuan;

public interface CreateElephant {


  Elephant createElephant(int height);

  public static void main(String[] args) {
    // 对于lambda表达式中只有一句语句的时候。如果需要调用构造方法返回对象，可以使用引用构造方法的方式。
    // 所实现的方法的入参作为构造方法的入参传入。
    CreateElephant createElephant = Elephant::new;
  }
}
