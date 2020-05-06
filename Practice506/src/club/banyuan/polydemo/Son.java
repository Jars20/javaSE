package club.banyuan.polydemo;

public class Son extends Father {

  @Override
  public String getFatherFieldOverride() {
    return "OverrideBySon";
  }


  public static void main(String[] args) {
    Father father = new Son();
    System.out.println(father.getFatherField());
    System.out.println(father.getFatherFieldOverride());

    Father realFatherObj = new Father();
    System.out.println(realFatherObj.getFatherField());
    System.out.println(realFatherObj.getFatherFieldOverride());

  }
}
