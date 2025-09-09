package String;

public class StringMatch {
  public static void main(String[] args) {
    String text = "How are you";
    String myMail = "sirr@mymail.com";
    System.out.println(text.matches("^[aeiouAEIOU]"));
    System.out.println(myMail.matches("^([a-zA-Z0-9.-]+)@mymail.([a-zA-Z]{2,5})$"));
  }
}
