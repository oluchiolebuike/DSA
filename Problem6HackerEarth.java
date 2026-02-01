/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
import java.util.*;
class Problem6HackerEarth {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
         Scanner sc = new Scanner(System.in);
         int testCaseNo = Integer.parseInt(sc.nextLine());
         String palindromeString ;
         
         
         while (true){
             palindromeString = sc.nextLine();
            
            // for each line 
          //  String build = "";
            int count = 0;
            ArrayList<String> stringArr = new ArrayList<>();
         
             // aaddg
             while ( count <= testCaseNo ){
             for (int i = 0;  i < palindromeString.length(); i++){
               for (int j = 0; j < palindromeString.length(); j++){
                  if (i < j){
                     String lineSub = palindromeString.substring(i,j);
                     
                      if (lineSub.length() > 1){
                    if (isPalindrome(lineSub)){
                     
                     
                     if (stringArr.contains(lineSub)){
                        stringArr.add(lineSub);// prevent other 
                        count++;
                     }
                    } 
                  }

                  }
                 // build += charAt(i) + charAt(j);
                                }
             }
             }
             
             System.out.println(count);
             
             if (palindromeString.isEmpty()){
               break;
             }
         }
		   
         // close Scanner
         sc.close();
    }
    // substring method 
    public static boolean isPalindrome(String s){
      String build = "";
      String OG = s.toLowerCase();
      for (int i = s.length() - 1 ; i > 0 ;i--){
         build += s.charAt(i);
      }
      
      if (OG.equals(build)){
         return true;
      }
      
      return false;
    }
}
