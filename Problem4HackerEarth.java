import java.util.*;
public class Problem4HackerEarth{
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      
      //index length
      long n = sc.nextLong();
      String str = sc.next();
      int i = 0;
      int count = 0;
      //0010010
     // String[] arr = str.split(" ");
      // if i + 2 == 0 skip
      
      while (i < n - 1){
         if (i + 2 < n && str.charAt(i + 2)== '0' ){
            i = i + 2;
         } else {
            i = i + 1;
         }
         count++;
      }
      
      System.out.println(count);
   }
}