package club.banyuan;

public interface Finder {

  int find(String s1, String s2);

  public static void main(String[] args) {
    // 如果lambda中只有一句话，这个语句调用了一个静态方法作为返回值，可以简写为如下方式
    // 需要保证静态方法的参数列表doFind 和重写的接口方法find的参数列表一致
    Finder finder = FinderRef::doFind;

    Finder finder1 = String::indexOf;
  }
}