import java.io.*;
import java.util.*;

public class Turnaround{
   public static void main(String[] args){
      // read in name of text file
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the name of the trace file.");
      String fileName = sc.nextLine();
      
      try {
         // Read through file
         Scanner fileIn = new Scanner(new File(filename));
       
         // Use hash map to associate ID with ready time and terminate ID
         Map<String, Integer>readyTimes = new HashMap<>();
         Map<String, Integer>terminateTimees = new HashMap<>();
         
         // Line by line
          while (fileIn.hasNextLine()){
            String line = fileIn.nextLine().trim();
               
               //if (line.isEmpty()) continue;
               String[] parts = line.split("\\s+");
               //if (parts < 4) continue;
               
               String timeStr = parts[0];
               String processId = parts[1];
               String eventType = parts[3];
               
               // Convert
               int time = Integer.parseInt(timeStr);
               
               if (eventType.equals("READY")){
                  // Only record the first ready
                  readyTimes.putIfAbsent(processid, time);
                } else if (eventType.equals("TERMINATE")){
                  terminateTimes.put(processID, time);
                  
                }
               }
               // Close scanner
               fileIn.close();
                     
            }
            
            // If PID match calulate time
            for (String pid: readyTimes.keySet()){
               if(terminateTimes.containsKey(pid)){
                  int turnaround = terminateTimes.get(pid) - readyTimes.get(pid);
                   System.out.println("Turnaround time for process " + pid + ": " + turnaround);
                } else {
                    System.out.println("Process " + pid + " did not terminate.");
                }
            }
            }
          }        
      }
   
