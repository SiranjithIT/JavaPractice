package Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PracticeArrays {
  public static void main(String[] args) {
    // int[] arr = new int[]{3, 5, 8, 1, 9, 2, 4};
    // int n = arr.length;
    // //Arrays.sort(arr);
    // Arrays.sort(arr, 0, n);
    // System.out.println("Length of the array"+Integer.toString(n)+"\n\n");
    // for(int i: arr) System.out.println(i);
    // System.out.println("\n\n");
    // int[] copyArr = Arrays.copyOfRange(arr, 3, n);
    // for(int i: copyArr) System.out.println(i);

    int[] arr = new int[]{10, 9, 3, 4, 6, 12, 89, 34};
    Arrays.sort(arr);

    String arrStr = Arrays.toString(arr);
    String[] splitArr = arrStr.split(",");
    System.out.println(arrStr);
    for(String s: splitArr) System.out.println(s);

    int[] arr1 = new int[]{2,7,11,15, 8, 5};
    Map<Integer, Integer> mp = new HashMap<>();
    int n = arr1.length;
    for(int i = 0;i < n;i++){
      if(arr1[i] > 9) continue;
      int diff = 9 - arr1[i];
      System.out.println("Value: "+Integer.toString(i)+" - "+Integer.toString(diff));
      if(mp.containsKey(arr1[i])){System.out.println("Ans: "+ Integer.toString(mp.get(arr1[i])) + " , "+ Integer.toString(i)); break;}
      else{
        mp.put(diff, i);
      }
    }
    System.out.println("End..");
  }
}
