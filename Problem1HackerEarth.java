import java.util.*;
public class Problem1HackerEarth{
   public static void main (String[] args){
      Scanner sc = new Scanner(System.in);
      
      long T = sc.nextLong();;// N
      String s = sc.next(); // abcac
      sc.close();
      
      int lengthString = s.length();// 5

        // get count of a's
      long count = 0;
      for (char c : s.toCharArray()){
         if (c == 'a'){
            count++;
         }
      }
     // int add = T - lengthString;// aba - 7 / 2 = 3 abaabaabaa
      
      // add substring to OG
      long num = T / lengthString;
      
      long total = num * count;
      
      long rem = T % lengthString;
      
      for (int i = 0 ; i < rem; i++){
         if (s.charAt(i) == 'a'){
            total++;
         }
      }
      
    //  String newS = s;
     // while (num--> 0){
    //     newS += s;
         
    //   }
       

       
      // if (rem > 0){
     //       for (int i = 0; i < rem; i++){
     //          newS += s.charAt(i);
            
     //   }

     //  }
    
      
      System.out.println(total);

   }
}