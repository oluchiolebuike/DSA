import java.util.*;
import java.io.*;

public class Frequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String filename = sc.nextLine().trim();
        
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            HashMap<String, Integer> wordCount = new HashMap<>();
            
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim().toLowerCase();
                String[] words = line.split("\\s+");
                
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
            
            // Convert to list for sorting
            List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordCount.entrySet());
            
            // Sort by frequency (descending)
            entries.sort((a, b) -> b.getValue() - a.getValue());
            
            System.out.println("\nWord Frequencies:");
            for (Map.Entry<String, Integer> entry : entries) {
                System.out.printf("%-10s: %d%n", entry.getKey(), entry.getValue());
            }
            
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        
        sc.close();
    }
}
