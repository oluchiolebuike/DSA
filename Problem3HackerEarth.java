public class Problem3HackerEarth{
   public static void main (String[] args){
      // consecutive
      // cloud == no. current cloud + 1 or 2
      // cumulus vs thunderheads
      // no of jumps: start to finish
      
      // 0: safe
      // 1: avoid
      
      // min jumps
      
      Scanner sc = new Scanner(System.in);
      long n = sc.nextLong();// optimal
      // read string array
      // test if 1
      // count 0's
      // odd count of 0's: -1
      
      // check if length odd or even
      
      // 0010010
      //000010
      //0010000100
      
      // skip 0 if > 2 000 0000
      //
      int count = 0;
      for (int i = 0; i < stringArr.length;i){
         if (i+2 < stringArr.length && stringArr.charAt(i+2) == 0){
            i = i+2;
         } else {
            i = i+1;
         }
         count++;
      }
      
   }
}