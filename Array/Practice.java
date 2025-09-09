package Array;

public class Practice {
  public static void main(String arg[]){
    int[] arr = {1, 2, 3, 4, 5};
    char[] charArr = new char[5];
    for(int i = 0;i < 5;i++){
      charArr[i] = (char)('a'+i);
    }
    System.out.println(charArr.getClass());
    System.out.println(arr.getClass());
  }
}
