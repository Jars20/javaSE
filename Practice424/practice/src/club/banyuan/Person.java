package club.banyuan;

public class Person {

  public static int num = 0;
  public static int count = 0;
  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
    Person.num++;
    Person.count++;
  }

  public Person(String name) {
    this.name = name;
    Person.num++;
  }

  public Person() {
    Person.num++;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

}
