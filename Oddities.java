import java.util.*;
import java.io.*;

public class Oddities {
   public static void main(String[] args) {
      try {   
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter the name of the text file of dates: ");
         String fileName = sc.nextLine();
         
         Scanner fileSc = new Scanner(new File(fileName));
         
         while (fileSc.hasNextLine()) {
            String line = fileSc.nextLine();
            
            String[] parts = line.split("/");
            
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);
            
            String OGLine = line;
            int numDays = 0;
            
            // Check if all digits are odd
            if (allDigitsOdd(day, month, year)) {
               System.out.println("The date " + line + " has all odd digits.");
            } else {
               // Loop until we find a date with all odd digits
               while (!allDigitsOdd(day, month, year)) {
                  day++;
                  
                  // Check if day exceeds month's limit
                  if (day > numDays(month, year)) {
                     day = 1;
                     month++;
                     
                     // Check if month exceeds 12
                     if (month > 12) {
                        month = 1;
                        year++;
                     } 
                  }
                  
                  numDays++;
               }
          
               // Display result
               String result = "The first date after " + OGLine + " with all odd digits is " + 
                              day + "/" + month + "/" + year + " which is " + numDays;
               if (numDays == 1) {
                  System.out.println(result + " day later.");
               } else {
                  System.out.println(result + " days later.");
               } 
            }
         }
         
         System.out.println("Done");
         sc.close();
         fileSc.close();  
      } catch (FileNotFoundException e) {
         System.out.println("File not found!");
      }
   }
   
   // Check if ALL digits in day, month, and year are odd
   public static boolean allDigitsOdd(int day, int month, int year) {
      String combined = "" + day + month + year;  // Combine into string
      
      for (int i = 0; i < combined.length(); i++) {
         char digitChar = combined.charAt(i);
         int digit = Character.getNumericValue(digitChar);  // Convert char to int
         
         if (!isOdd(digit)) {
            return false;  // If any digit is even, return false
         }
      }
      
      return true;  // All digits are odd
   }
   
   // Check if a single digit is odd
   public static boolean isOdd(int num) {
      int[] odd = {1, 3, 5, 7, 9};
      
      for (int i = 0; i < odd.length; i++) {
         if (num == odd[i]) {
            return true;
         }
      }
      return false;
   }
   
   public static boolean leapYear(int year) {
      return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
   }
   
   public static int numDays(int month, int year) {
      if (month == 2) {
         return leapYear(year) ? 29 : 28;
      } else if (month == 4 || month == 6 || month == 9 || month == 11) {
         return 30;
      } else {
         return 31;
      }
   }
}