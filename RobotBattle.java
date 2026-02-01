import java.io.*;
import java.util.*;

public class RobotBattle {
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter filename:");
      String fileName = sc.nextLine();
      
    try {
      Scanner fileSc = new Scanner(new File(fileName));
      HashMap<String, Integer> robotHealth = new LinkedHashMap<>();
      List<String[]> bumps = new ArrayList<>();

         while (fileSc.hasNextLine()){
            String line = fileSc.nextLine();
            if (line.isEmpty()) continue;
            
            String[] parts = line.split("\\s+");
            if (parts.length == 2 && Character.isDigit(parts[1].charAt(0))){
               String robotName = parts[0];
               int health = Integer.parseInt(parts[1]);
               robotHealth.put(robotName,health);
               continue;
            }
            
            if (parts.length == 2){
               bumps.add(parts);
            }
         }
         
         System.out.println("Processing battles...");
         
         // List<Boolean> elim = new ArrayList<>();

         // Battle rules
        // boolean eliminated = false;
         for (String [] bump : bumps){ 
            String attacker = bump[0];
            String def = bump[1];
            
            System.out.printf("Battle: %-10s vs %-10s%n", attacker, def);
            int a = robotHealth.get(attacker);
            int d = robotHealth.get(def);
            
            if (a > d && a >=10){
               a -= 10;
               d -= 15;
            } else if (a > d && a < 10){
              
               d -= a;
                a = 0;
            } else if (a < d && d >= 10){
               d -= 5;
               a += 5;
            } else if (a < d && d < 10){
               a += d;
               d = 0;
            } else if (a==d) {
               a -= 5;
               d -= 5;
            }
           
            
            robotHealth.put(attacker,Math.max(a,0));
            robotHealth.put(def,Math.max(d,0));
         }
         
         System.out.println("Final health levels:");
         int activeCount = 0;
         for (Map.Entry<String, Integer> entry : robotHealth.entrySet()){
            if (entry.getValue() > 0){
            System.out.printf("%-10s : %d%n" , entry.getKey(), entry.getValue());
            activeCount++;
            } else {
                System.out.printf("%-10s : ELIMINATED%n" , entry.getKey());
            }
           
         }
 
         sc.close();
         fileSc.close();
      } catch (FileNotFoundException e){  
      }
   }
}