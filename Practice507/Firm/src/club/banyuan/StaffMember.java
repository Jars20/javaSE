package club.banyuan;

/**
 * 一般职员
 */
abstract public class StaffMember {

  protected String name;
  protected String address;
  protected String phone;

  // 使用指定的信息设置工作人员。
  public StaffMember(String eName, String eAddress, String ePhone) {
    name = eName;
    address = eAddress;
    phone = ePhone;
  }

  //返回包含基本员工信息的字符串
  public String toString() {
    String result = "姓名: " + name + "\n";
    result += "住址: " + address + "\n";
    result += "电话: " + phone;
    return result;
  }

  // 派生类必须为每种类型的员工定义薪酬方法
  public abstract double pay();
}