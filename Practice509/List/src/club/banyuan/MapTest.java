package club.banyuan;

public class MapTest {

  public static void main(String[] args) {
    Map map = new HashMap();
    map.put("abc","bcd");
    map.put("abc","bcd");
    map.put("abc","bcd");
    map.put("abc","123456");
    System.out.println(map.size());
    System.out.println(map.get("123"));
    System.out.println(map.get("abc"));
  }
}
