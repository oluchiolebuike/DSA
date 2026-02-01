import java.util.*;
public class Problem2HackerEarth{
   public static void main (String[] args){
      Scanner sc = new Scanner(System.in);
      
      int T = Integer.parseInt(sc.nextLine());// Test cases
      long cycles = sc.nextLong();
      long heightBegin = sc.nextLong();
      // spring summer autumn winter spring summer 
      // x2 each year 
      // x2 every spring
      // +1 summer
      // 1 x 2 + 1 x 2 +1 x2 + 1
      
      // loop
      while (T --> 0){ 
      // Tn = 2^n+1 - 1
      // T5 = 2 ^5+1 - 1
      long years = cycles / 2;
      long height = (long) Math.pow(2, years +1)-1;
      if (cycles % 2 != 0){
          height *= 2;
      }
     
      System.out.println(height);
      }
      sc.close();
   }
}