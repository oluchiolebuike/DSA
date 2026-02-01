import java.io.*;
import java.util.*;

public class StudentGradesTracker{
   public static void main (String[] args){
      try{
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter filename: ");
         String fileName = sc.nextLine();
         
        // Data Structure 
        Map<String,ArrayList<Integer>> studentScores = new HashMap<>();
         Scanner fileSc = new Scanner(new File(fileName));
         while (fileSc.hasNextLine()){
            String line = fileSc.nextLine();
            if (line.isEmpty()) continue;
            // read line by line 
            // get name string get scores int
            // if already in list add to arraylist then loop through arraylist for each student sum and then divide by the size of arraylist
            String[] parts = line.split(" "); // Alice,85
            
            if (parts.length!=2) continue;
            String studentName = parts[0];
            int score = Integer.parseInt(parts[1]);
            
            // add to hashmap add to arraylist
            studentScores.putIfAbsent(studentName,new ArrayList<Integer>());
            studentScores.get(studentName).add(score);// Alice 85 90 92 95
           } // if we have a data structure to store dont continue to loop
            double avg = 0;
            // loop through arraylist advance for
            for (Map.Entry<String,ArrayList<Integer>> entry : studentScores.entrySet()){
               // get list [85,90,92,95] 
              ArrayList<Integer> scores = entry.getValue(); // each student
              String name = entry.getKey();
              int sum = 0;
              for (Integer scoreItem : scores){
                  sum += scoreItem;
             
              }
                    avg = sum / scores.size();
             
               // display for each entry     
              System.out.printf("%-10s:%.2f%n",name,avg);
              
            }
            
         
       sc.close();
       fileSc.close();
      } catch (FileNotFoundException e){
      }
   }
}