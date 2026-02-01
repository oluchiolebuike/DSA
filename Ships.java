import java.util.*;
import java.io.*;

public class Ships {
   public static void main(String[] args){
      
      // intersection = xi, yi
      // line eq : a1x+b1y+c1 = 0
      //two ships x1y1 x2y2
      
      // calc
      // nearest distance  to xi,yi shortest
      // a b c x y
      // < 0.5 : tie
      
      // ship 1
      // ship2
      // no second ship??
      // one ship only??
      // nearest if 1 if 2 tied
      try{   
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter the name of the ship data file:");
         String fileName = sc.nextLine();
         
         Scanner fileSc = new Scanner(new File(fileName));
         // read text file
         int pair = 1;
         while (fileSc.hasNextLine()){
            String line = fileSc.nextLine();//1 2 1 -3 1
            
            // ship 1
            String[] ship1 = line.split(" ");// 1,2,1,-3,1
            double a1 = Double.parseDouble(ship1[0]);
            double b1 = Double.parseDouble(ship1[1]);
            double c1 = Double.parseDouble(ship1[2]);
            double x1 = Double.parseDouble(ship1[3]);
            double y1 = Double.parseDouble(ship1[4]);
                       // go to next line for ship 2
            //fileSc.nextLine();
            
            // ship 2
            // if no ship 2??
            //if (line.isEmpty()) continue; // no second line??
            String line2 = fileSc.nextLine();
            String[] ship2 = line2.split(" ");// 1,2,1,-3,1
            double a2 = Double.parseDouble(ship2[0]);
            double b2 = Double.parseDouble(ship2[1]);
            double c2 = Double.parseDouble(ship2[2]);
            double x2 = Double.parseDouble(ship2[3]);
            double y2 = Double.parseDouble(ship2[4]);
            
            // process in pairs
            
            // first calculate intersection
            double xi = ((b1 * c2 )- (b2 * c1)) / ((a1 * b2) - (a2*b1));
            double yi = ((a2 * c1) - (a1 * c2)) / ((a1 *b2) - (a2 * b1));
           // System.out.printf("%.2f : %.2f",xi,yi);
            // see distance
            double dist1 = distance(x1,y1,xi,yi);
            double dist2 = distance(x2,y2,xi,yi);
            
            // test nearest if dist1 < dist2 dist1 nearest if dist1 - dist2 < 0.5 tie
            // math.abs 0 ??
            String result = "";
            if (Math.abs(dist1 - dist2) < 0.5){
               result += "Tied.";
            } else if (dist1 < dist2){
              result += "Ship S1 is nearest."; 
            } else if (dist2 < dist1){
              result += "Ship S2 is nearest.";
            }            
            System.out.printf("Pair %d: Intersection point: (%.1f, %.1f); Ship S1's distance is %.1f; Ship S2's distance is %.1f; %s%n",pair,xi,yi,dist1,dist2,result);
            pair++;
         }
         
         System.out.println("Done");
         // close scanners
         sc.close();
         fileSc.close();
      } catch (FileNotFoundException e){
      }
   }
   
   public static double distance(double xa, double ya, double xb, double yb ){
      return (Math.sqrt(Math.pow(xb-xa,2) + Math.pow(yb - ya,2)));
   } 
}