import java.util.*;
public class Problem5HackerEarth{
   public static void main (String[] args){
      // n length m queries
      // k value to replace in and then add
      // if i = n = m put in array k
      // get max value
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int m = sc.nextInt();
      
      long[] arr = new long[n+1];

      
      for (int i = 0; i < m; i++){
         int a = sc.nextInt();
         int b = sc.nextInt();
         int k = sc.nextInt();
      // arr of 0's
      // put in that pos
         
         arr[a - 1] = arr[a] + k;
         if (b < n){
            arr[b] -= k;
         }
      
      }
      //int i = 0;
      long max = 0;
      //long current = 0;
      
      for (int i = 0; i < n; i++){         
         if (max < arr[i]){
            max = arr[i];
         }
       }
      
      
      System.out.println(max);
     }
}