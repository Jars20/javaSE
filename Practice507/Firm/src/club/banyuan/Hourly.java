package club.banyuan;

/**
 * 定义按小时收取薪水的员工
 */
public class Hourly extends Employee {

  private int hoursWorked;

  // 使用指定的信息设置此小时工
  public Hourly(String eName, String eAddress, String ePhone,
      String socSecNumber, double rate) {
    super(eName, eAddress, ePhone, socSecNumber, rate);
    hoursWorked = 0;
  }

  // 将指定的小时数添加到该员工的累计小时数中
  public void addHours(int moreHours) {
    hoursWorked += moreHours;
  }

  //计算并返回该小时工的工资
  public double pay() {
    double payment = payRate * hoursWorked;
    hoursWorked = 0;
    return payment;
  }

  // 以字符串形式返回有关该小时工的信息
  public String toString() {
    String result = super.toString();
    result += "\n工作时长: " + hoursWorked;
    return result;
  }
}