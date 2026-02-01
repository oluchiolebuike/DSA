import java.util.*;
import java.io.*;

public class MazeSolver {
    public static void main(String[] args) {
        Scanner fileSc = null;
        
        try {
            fileSc = new Scanner(new File("maze.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Error: maze.txt file not found!");
            return;
        }
        
        // Read dimensions
        int row = fileSc.nextInt();
        int col = fileSc.nextInt();
        fileSc.nextLine(); // consume newline
        
        char[][] maze = new char[row][col];
        int startRow = -1, startCol = -1;
        int endRow = -1, endCol = -1;
        
        // Display top border
        String lineBuilder = "+";
        for (int i = 0; i < col; i++) {
            lineBuilder += "-";
        }
        lineBuilder += "+";
        System.out.printf("%-" + col + "s", lineBuilder);
        System.out.println();
        
        // Read maze
        int currentRow = 0;
        while (fileSc.hasNextLine()) {
            String line = fileSc.nextLine();
            
            for (int j = 0; j < col && j < line.length(); j++) {
                maze[currentRow][j] = line.charAt(j);
                
                if (maze[currentRow][j] == 'S') {
                    startRow = currentRow;
                    startCol = j;
                }
                if (maze[currentRow][j] == 'E') {
                    endRow = currentRow;
                    endCol = j;
                }
            }
            
            System.out.printf("|%-" + col + "s", line);
            System.out.print("|");
            System.out.println();
            currentRow++;
        }
        
        // Display bottom border
        System.out.printf("%-" + col + "s", lineBuilder);
        System.out.println();
        
        fileSc.close();
        
        // Direction sequence
        String sequence = "LRRRUUUD";
        
        System.out.println("\nStart position: (" + startRow + ", " + startCol + ")");
        System.out.println("End position: (" + endRow + ", " + endCol + ")");
        System.out.println("Direction sequence: " + sequence + "\n");
        
        // Solve maze
        int currentPosRow = startRow;
        int currentPosCol = startCol;
        boolean found = false;
        int step = 0;
        List<int[]> path = new ArrayList<>();
        path.add(new int[]{currentPosRow, currentPosCol});
        
        while (!found && step < 1000) {
            char direction = sequence.charAt(step % sequence.length());
            int newRow = currentPosRow;
            int newCol = currentPosCol;
            
            // Determine new position
            switch (direction) {
                case 'L': newCol--; break;
                case 'R': newCol++; break;
                case 'U': newRow--; break;
                case 'D': newRow++; break;
            }
            
            // Check if valid move
            if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col 
                && maze[newRow][newCol] != '#') {
                currentPosRow = newRow;
                currentPosCol = newCol;
                
                if (maze[newRow][newCol] == 'E') {
                    found = true;
                    path.add(new int[]{currentPosRow, currentPosCol});
                    System.out.println("Step " + (step + 1) + ": Move " + direction 
                        + " to (" + currentPosRow + ", " + currentPosCol + ") - FOUND END!");
                } else {
                    path.add(new int[]{currentPosRow, currentPosCol});
                    System.out.println("Step " + (step + 1) + ": Move " + direction 
                        + " to (" + currentPosRow + ", " + currentPosCol + ")");
                }
            } else {
                System.out.println("Step " + (step + 1) + ": Move " + direction 
                    + " - Hit wall/boundary, staying at (" + currentPosRow + ", " 
                    + currentPosCol + ")");
            }
            
            step++;
        }
        
        // Print final maze
        if (found) {
            System.out.println("\n✓ End found in " + step + " steps!");
            System.out.println("\nFinal maze with path marked as '.':");
            
            char[][] resultMaze = new char[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    resultMaze[i][j] = maze[i][j];
                }
            }
            
            for (int[] pos : path) {
                if (resultMaze[pos[0]][pos[1]] != 'S' && resultMaze[pos[0]][pos[1]] != 'E') {
                    resultMaze[pos[0]][pos[1]] = '.';
                }
            }
            
            // Display final maze with borders
            System.out.printf("%-" + col + "s", lineBuilder);
            System.out.println();
            for (int i = 0; i < row; i++) {
                String line = new String(resultMaze[i]);
                System.out.printf("|%-" + col + "s", line);
                System.out.print("|");
                System.out.println();
            }
            System.out.printf("%-" + col + "s", lineBuilder);
            System.out.println();
        } else {
            System.out.println("\nEnd not found.");
        }
    }
}