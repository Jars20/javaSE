import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

  public static void main(String[] args) {
    test8();
  }

  public static void test1() {
    String text =
        "This is the text to be searched " +
            "for occurrences of the http:// pattern.";

    String regex = ".*http://.*";

    boolean matches = Pattern.matches(regex, text);

    System.out.println("matches = " + matches);

    System.out.println(text.matches(regex));

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);
    if (matcher.find()) {
      System.out.println(matcher.matches());
    }
  }

  public static void test2() {
    String text =
        "This is the text which \\ is to be searched " +
            "for occurrences [ of the word`is' ].";

    String regex = "\\[.*]";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);

    int count = 0;
    while (matcher.find()) {
      System.out.println(matcher.group());
      count++;
      System.out.println("found: " + count + " : "
          + matcher.start() + " - " + matcher.end());
    }
  }

  public static void test3() {
    String text = "Line 1\nLine2\nLine3";

    Pattern pattern = Pattern.compile("(?m)^");
    Matcher matcher = pattern.matcher(text);

    while (matcher.find()) {
      System.out.println("Found match at: " + matcher.start() + " to " + matcher.end());
    }
  }

  public static void test4() {
    String[] text = {"http://test.com", "https://banyuan.cou", "ftp://123.txt"};

    for (String s : text) {
      if (!s.startsWith("http://") && !s.startsWith("https://")) {
        System.out.println(s);
      }
    }

    Pattern pattern = Pattern.compile("http://|https://");
    for (String s : text) {
      Matcher matcher = pattern.matcher(s);
      if (!matcher.find()) {
        System.out.println(s);
      }

    }
  }

  public static void test5() {
    String text = "Mary had a little lamb";

    Pattern pattern = Pattern.compile("\\b");
    Matcher matcher = pattern.matcher(text);

    while (matcher.find()) {
      System.out.println(matcher.group().length());
      System.out.println("Found match at: " + matcher.start() + " to " + matcher.end());
    }
  }

  public static void test6() {
    String text = "one   two \t  three   two one";

    // String[] twos = text.split("two");
    // String[] twos = text.split("\\s+");
    String[] twos = text.split("[ \\t]+");
    System.out.println(Arrays.toString(twos));
  }

  public static void test7() {
    String text = "one two three two one";

    String s = text.replaceFirst("two", "five");
    System.out.println(s);
    String s1 = text.replaceAll("five", "six");
    System.out.println(s1);
  }

  public static void test8() {
    String text = "one two three two one";

    // 通过左括号查看分组编号
    Pattern pattern = Pattern.compile("two(.*(ree)\\s)two");
    Matcher matcher = pattern.matcher(text);
    if (matcher.find()) {
      System.out.println(matcher.group(0));
      System.out.println(matcher.group(1));
      System.out.println(matcher.group(2));
    }

    // String s = text.replaceFirst("two", "five");
    // System.out.println(s);
    // String s1 = text.replaceAll("five", "six");
    // System.out.println(s1);
  }
}
