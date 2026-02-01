import java.util.*;
public class utopianTree{
   public static int utopianTree(int n){
      return (1<< ((n >> 1) + 1) - 1 <<( n % 2));
   }
   
   public static void main (String[] args){
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();

   for (int i = 0; i < T; i++){
     int cycle = sc.nextInt();
     System.out.println(utopianTree(cycle)); 
   }
   sc.close();
   }
}