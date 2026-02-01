import java.io.*;
import java.util.*;

public class Check{
   public static void main (String[] args){
      // if split attributes isDistinct(card1, card2) && isDistinct(card2, card3) && isDistinct(card1, card3)
      try {
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter the name of the cards file:");
         String fileName = sc.nextLine();
         
         // File scanner
         Scanner fileSc = new Scanner(new File(fileName));
         
         while (fileSc.hasNextLine()){
            String line = fileSc.nextLine();
            //if (!line.isEmpty()) continue;
            
            String[] parts = line.split(" "); // 3 separate cards [square,red,solid]
            
            // no loop just use index
           String[] att1 = parts[0].split(",");// card 1
           String[] att2 = parts[1].split(",");// card 2
           String[] att3 = parts[2].split(",");// card 3
           System.out.println("Processing: "+line);
           
           if ((isDistinct(att1,att2) && isDistinct(att2,att3) && isDistinct(att1, att3))  || (isSame(att1,att2) && isSame(att2, att3) && isSame(att1,att3))){
            System.out.println("Valid");
           } else {
            System.out.println("Invalid");
           }

            
         }
          System.out.println("Done");
         // close Scanners
         sc.close();
         fileSc.close();
      } catch (FileNotFoundException e){
      }
      
      
   }
   
   // method distinct two cards
   
   public static boolean isDistinct(String[] card1, String[] card2){
    if (!(card1[0].equalsIgnoreCase(card2[0])) &&  !(card1[1].equalsIgnoreCase(card2[1])) && !(card1[2].equalsIgnoreCase(card2[2])) ) {
      return true;
    } else {
      return false;
    }
   }
   // method same
   public static boolean isSame(String[] card1, String[] card2){
      // compare 3 cards
      if (card1[0].equalsIgnoreCase(card2[0]) &&  card1[1].equalsIgnoreCase(card2[1]) && card1[2].equalsIgnoreCase(card2[2]) ) {
      return true;
    } else {
      return false;
    }
   }
}