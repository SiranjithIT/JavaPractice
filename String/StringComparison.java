package String;

public class StringComparison {
  public static void main(String[] args) {
    String str1 = "Hello,";
    String str2 = "How";
    String str3 = "hello,";

    System.out.println(str1.equals(str3));
    System.out.println(str1.equalsIgnoreCase(str3));
    System.out.println(str2.startsWith("Ho"));
    System.out.println(str3.endsWith("lo,"));

    String one   = "abc";
    String two   = "def";
    String three = "abd";

    System.out.println( two.compareTo(one));
    System.out.println( one.compareTo(three) );
  }
}
