package String;

public class StringBuilderPrac {
  public static void main(String[] args) {
    String[] strs = new String[]{"Hello", "How", "Are", "You", "Doing"};
    StringBuilder res = new StringBuilder();
    for(String str: strs){
      res.append(" "+str);
    }
    String finalRes = res.toString().strip();
    System.out.println(finalRes);
    System.out.println(finalRes.length());
    System.out.println(finalRes.substring(1, 4));
    System.out.println(finalRes.indexOf("Are"));
  }
}
