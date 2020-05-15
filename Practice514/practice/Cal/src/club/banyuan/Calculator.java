package club.banyuan;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * Calculator类提供了用于解析包含简单表达式的输入字符串以及计算表达式结果的功能。
 */

public class Calculator {

    public Calculator() {
    }

    /**
     * 0 个符号: IllegalInputException: "Illegal Token Length"
     * 1 个符号:
     * "quit" (不区分大小写): QuitException
     * 所有其他情况: IllegalInputException: "Illegal Argument"
     * 2 个符号:
     * "-" 和数字: 返回负数
     * "-" 和非数字: IllegalInputException: "Illegal Argument"
     * 其他字符串: IllegalInputException: "Illegal Operator"
     * 3 个符号:
     * 数字1, "+", 数字2: 返回两个数字的和
     * 数字1, "/", 0: DivideByZeroException
     * 数字1, "/", 非零数字:  返回两个数字的商
     * 非数字，其他输入，其他输入: IllegalInputException: "Illegal Argument"
     * 数字1, 其他输入, 非数字: IllegalInputException: "Illegal Argument"
     * 数字1, 非运算符, 数字2: IllegalInputException: "Illegal Operator"
     * 4 更多的运算符: IllegalInputException: "Illegal Token Length"
     * <p>
     * Note: 所有数字都是整数
     *
     * @param tokens 符号数组，包含用户输入的操作数或操作符
     * @return 计算表达式的结果
     * @throws CalculatorException 如果用户输入不合法，或者已键入“ quit”。抛出CalculatorException 的几个子类之一，以便提供有关错误原因的更多信息.
     */
    public static int compute(String[] tokens) throws CalculatorException, IllegalInputException, QuitException {
        // 不同符号数量的各种情况
        switch (tokens.length) {
            case 0:
                System.out.println("0");
                // TODO: complete the cases
                throw new IllegalInputException("Illegal Token Length");

            case 1:
                System.out.println("1");

                // 只有一种情况，用户输入 quit
                // TODO: complete the cases
                if (tokens[0].equalsIgnoreCase("QUIT")) {
                    throw new QuitException();
                }
                throw new IllegalInputException("Illegal Argument");                             //其他异常

            case 2:
                System.out.println("2");

                // 只有一种情况，用户输入 负数
                // TODO: complete the cases
                if (tokens[0].equals("-") && isNUm(tokens[1])) {
                    return -toNum(tokens[1]);
                }
                throw new IllegalInputException("Illegal Argument");                             //其他异常


            case 3:
                System.out.println("3");

                // 计算表达式
                // TODO: complete the cases
                if (isNUm(tokens[0]) && isNUm(tokens[2])) {
                    switch (tokens[1]) {
                        case "+":
                            return toNum(tokens[0]) + toNum(tokens[2]);
                        case "-":
                            return toNum(tokens[0]) - toNum(tokens[2]);
                        case "*":
                            return toNum(tokens[0]) * toNum(tokens[2]);
                        case "/":
                            return toNum(tokens[0]) / toNum(tokens[2]);
                        default:
                            throw new IllegalInputException("Illegal Operator");
                    }
                }
                throw new IllegalInputException("Illegal Argument");                             //其他异常

            default:
                System.out.println("4");

                // 4个或等多操作符号抛出异常
                // TODO: complete the cases
                //长度异常
                throw new IllegalInputException("Illegal Token Length");

        }

    }

    /**
     * 将输入字符串解析为表达式并对其求值。
     * <p>
     * 如果输入是合法表达式，则打印结果
     * <p>
     * 否则抛出CalculatorException。根据异常类型打印消息。
     * <p>
     * 始终打印出输入内容。为此使用finally块。
     * <p>
     * 始终遵循以下规则打印两行：
     * 第一行:
     * -No Exception: "The result is: " + result
     * -QuitException: "Quitting"
     * -DivideByZeroException: "Tried to divide by zero"
     * -IllegalInputException: "Illegal input: " + illegalinputtype(given to constructor)
     * -CalculatorException: <should never happen> e.getMessage()
     * 第二行:
     * "Input was: " + input
     *
     * @param input 可能包含数学表达式的字符串
     * @return true 如果String等于"quit"; false 其他情况
     */
    public static boolean parseAndCompute(String input) {
        // 提取所有运算符号
        String[] tokens = input.split(" ");

        try {
            System.out.println("The result is: " + compute(tokens));
        } catch (QuitException e) {
            System.out.println("Quitting");
            return true;
        } catch (IllegalInputException e) {
            System.out.println("Illegal input: " + e.getExceptionType());
        } catch (CalculatorException e) {
            // 这捕获了剩下的CalculatorException情况：DivideByZeroException
            if (e instanceof DivideByZeroException) {
                System.out.println("Tried to divide by zero");
            }
            System.out.println(e.getMessage());
        } finally {
            // TODO：输出token的空格
            System.out.print("input was ");
            for (String token : tokens) {
                System.out.print(token + "");
            }
        }

        return false;
    }

    static private boolean isNUm(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    private static Integer toNum(String token) {
        return Integer.valueOf(token);
    }
}
