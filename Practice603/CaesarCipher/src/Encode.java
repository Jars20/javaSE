/**
 * 使用凯撒密码对英文的文本文件进行加密。
 * 凯撒密码是一种替换加密的技术，用于加密英文文本。
 * 将字母表上向后（或向前）按照一个固定数目进行偏移。使用偏移后的字母替换原始字母实现加密。
 * 例如，当偏移量是3的时候，所有的字母A将被替换成D，B变成E，以此类推。
 */

import java.io.*;

public class Encode {

  public static final int FIRST_UPPER = 65;
  public static final int FIRST_LOWER = 97;
  public static final int NUM_CHARS = 26;
  public static final int OFFSET = 3;

  public static void main(String[] args) throws IOException {
    BufferedReader inStream = null;
    BufferedWriter outStream = null;

    String inputFilePath = args[0];
    String outputFilePath = args[1];

    System.out.println("输入文件：" + inputFilePath);
    System.out.println("输出文件：" + outputFilePath);
// TODO
//完成此部分代码，调用 caesarEncode 对传入的inputFilePath文件进行加密
//将加密后的文本输出到 outputFilePath 文件中
//
    inStream = new BufferedReader(new FileReader(inputFilePath));
    outStream = new BufferedWriter(new FileWriter(outputFilePath));

    // String s = inStream.readLine();
    Decode.cipher(inStream, outStream, Encode::caesarEncode);
    System.out.println("加密成功！");
  }

  /**
   * 通过字母表偏移量对字母进行加密
   *
   * @param ch
   * @return
   */
  public static char caesarEncode(char ch) {

    if (Character.isUpperCase(ch)) {
      return (char) ((ch - FIRST_UPPER + OFFSET) % NUM_CHARS + FIRST_UPPER);
    } else if (Character.isLowerCase(ch)) {
      return (char) ((ch - FIRST_LOWER + OFFSET) % NUM_CHARS + FIRST_LOWER);
    } else {
      return ch;
    }
  }

}


