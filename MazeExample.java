import java.util.*;
import java.io.*;

public class MazeExample {
  public static void main (String[] args) throws FileNotFoundException{
     Scanner sc = new Scanner(System.in); 
     System.out.println("Enter filename: ");
     
     String filename = sc.nextLine();
     
     Scanner file = new Scanner(new File(filename));
     
     int rows = file.nextInt();// 5
     int cols = file.nextInt();// 5
     
     file.nextLine();
     
     char[][] maze = new char[rows][cols];
     
     int startRow = 0, startCol = 0, endRow = 0, endCol = 0;
     
     for (int i = 0; i < rows; i++){
      String line = file.nextLine();
      for (int j = 0; j < cols; j++){
         maze[i][j] = line.charAt(j);
         if (maze[i][j] == 'S'){
            startRow = i;
            startCol = j;
         }
         
         if (maze[i][j] == 'E'){
            endRow = i;
            endCol = j;
         }
      }
         
     } 
     
     // Print out maze
     for (int i = 0; i < rows; i++){
      for (int j = 0; j < cols; j++){
         System.out.print(maze[i][j] + " ");//use print instead
      }
      System.out.println();
     }
     
     boolean pathExists = hasPath(maze, startRow, startCol, endRow, endCol);
     System.out.println("\nPath exists: "+(pathExists ? "Yes" : "No"));
     
  } 
  
  // hasPath tests
  static boolean hasPath(char[][] maze, int row, int col, int endRow, int endCol){
   // check out of bounds??
   
   // hit wall or already visited
   if (maze[row][col] == '#' || maze[row][col] == 'V'){
      return false;
   }
   
   // Reached end
   if (row == endRow && col == endCol){
      return true;
   }
   
   // Mark current position as visited
   maze[row][col] = 'V';
   
   if (hasPath(maze, row + 1, col, endRow, endCol)) return true;
   if (hasPath(maze, row - 1, col, endRow, endCol)) return true;
   if (hasPath(maze, row, col + 1, endRow, endCol)) return true;
   if (hasPath(maze, row, col - 1, endRow, endCol)) return true;
  
  // No path found - Unmark
   maze[row][col] = ' ';
   return false;
  }
}