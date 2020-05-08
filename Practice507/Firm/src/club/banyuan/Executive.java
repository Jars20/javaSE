package club.banyuan;

/**
 * 定义可以赚取奖金的主管
 */
public class Executive extends Employee {

  private double bonus;

  // 设置具有指定信息的主管.
  public Executive(String eName, String eAddress, String ePhone,
      String socSecNumber, double rate) {
    super(eName, eAddress, ePhone, socSecNumber, rate);
    bonus = 0;  // 奖金尚未颁发
  }

  // 授予该主管指定的奖金.
  public void awardBonus(double execBonus) {
    bonus = execBonus;
  }

  // 计算并返回执行人员的薪水，即正式员工的薪水加上一次性奖金
  public double pay() {
    double payment = super.pay() + bonus;
    bonus = 0;
    return payment;
  }
}