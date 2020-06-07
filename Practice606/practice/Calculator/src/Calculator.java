import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculator {

  public static void main(String[] args) {
    System.out.println("请输入：");
    System.out.println("格式: num <operator> num");
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();

    Pattern pattern = Pattern.compile("^(\\d+.\\d+)\\s?<([\\+\\-\\*/%])>\\s?(\\d+.\\d+)$");

    Matcher matcher = pattern.matcher(input);

    if (matcher.matches()) {
      double num1 = Double.parseDouble(matcher.group(1));
      double num2 = Double.parseDouble(matcher.group(3));
      String operator = matcher.group(2);
      System.out.println("计算结果为" + Calculate(num1, num2, operator));
    }


  }

  private static double Calculate(double num1, double num2, String operator) {
    switch (operator) {
      case "+":
        return num1 + num2;
      case "-":
        return num1 - num2;
      case "*":
        return num1 * num2;
      case "%":
        return num1 / num2;
      default:
        throw new RuntimeException("格式错误");
    }
  }

}


