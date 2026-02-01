import java.io.*;
import java.util.*;

public class Cipher {
   public static void main (String[] args){
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter a message to encrypt or 'quit':");
      String line = sc.nextLine();// Hello World!
      
      String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";// length 26
      String lower = upper.toLowerCase();
      
         String build = "";
      while (!line.equalsIgnoreCase("quit")){
         //loop through each char in string 
         // first check if upper case
         int shiftKey = 0;
         
         // first loop through word to find vowels
         for (int i = 0; i < line.length(); i++){  
            if (isVowel(line.charAt(i))){
               shiftKey++;
            }
         }// shift key
      
         // test if uppercase then compare in string and use placeholder to get index
         int placeholder = 0;
      
            
            // if upperCase else 
            for (int j = 0 ; j < line.length() ; j++){
            if (Character.isUpperCase(line.charAt(j))){
               if (line.charAt(j) == upper.charAt(j)){// H
                  placeholder = i;
               }
               int newPos = placeholder;// H
            newPos ++;// 26 11
            // test if shiftKey == 26 set to 
 
                if (newPos >= 26){
              newPos = 0;
              newPos += shiftKey;//new letter upper.charAt(newPos) 
            } else {
              newPos -= 1;
              newPos += shiftKey;
            }
            
            build += upper.charAt(newPos);
            } else if (Character.isLowerCase(line.charAt(j))) {
                if (line.charAt(j) == lower.charAt(i)){// H e
                  placeholder = i;
               }
                int newPos = placeholder;// H
            newPos ++;// 26 11
            // test if shiftKey == 26 set to 

                 if (newPos >= 26){
              newPos = 0;
              newPos += shiftKey;//new letter upper.charAt(newPos) 
            } else {
              newPos -= 1;
              newPos += shiftKey;
            }
            
            build += lower.charAt(newPos);

            } else if("abcdefghijklmnopqrstuvwxyz".indexOf(line.charAt(j)) < 0){
               build += line.charAt(j);
            }
             }//for j         
      
         
         // ask ask for input
         if (!line.equalsIgnoreCase("quit")){
           System.out.println("Enter a message to encrypt or 'quit':");
            line = sc.nextLine();
            
         }
      }
      System.out.println(build);
      System.out.println("Done");
      sc.close();
   }
   
   public static boolean isVowel(char c){
      if ("aeiou".indexOf(c) >= 0){
         return true;
      }
      return false;
   }
}