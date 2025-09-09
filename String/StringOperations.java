package String;

public class StringOperations {
 public static void main(String[] args){
  String text    = "  And he ran across the field   ";
  System.out.println(text);
  System.out.println(text.trim());
  System.out.println(text.strip());

  String s = "\u2001String with wide spaces\u2001";
  System.out.println(s.trim());  // outputs the original string with wide spaces
  System.out.println(s.strip()); // outputs string without the wide spaces

  String source = "abc#asf.com";
  System.out.println(source.replace('#', '@'));

  String text1 = "one two three two one";
  System.out.println(text1.replaceFirst("two", "five"));
  System.out.println(text1.replaceAll("two", "five"));

  String source1 = "A man drove with a car.";
  String[] spl = source1.split("a");
  for(String sp: spl) System.out.println(sp.strip());

  String[] spl1 = source1.split("a", 2);
  for(String sp1: spl1) System.out.println(sp1);

  String input = "Hello %s";

  String output1 = input.formatted("World");
  System.out.println(output1);

  String output2 = input.formatted("Jakob");
  System.out.println(output2);

 } 
}
