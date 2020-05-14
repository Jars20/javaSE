package club.banyuan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 从用户键盘读取输入。每读一行，尝试将其解释为数学表达式并打印出结果（或错误消息）。
 * 只要用户没有要求退出程序，就继续读取
 */

public class Driver {

    /**
     * @param args 未使用
     * @throws IOException 如果发生IO错误
     */
    public static void main(String[] args) throws IOException {

        // 开启输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 循环直到退出
        while(true)
        {
            // 读下一行输入
            String input = br.readLine();

            // 解析，计算并报告结果
            if(Calculator.parseAndCompute(input)) 
            {
                // 指定程序退出
                break;
            }

        }

        // 关闭缓冲的读取器
        br.close();
    }
}
