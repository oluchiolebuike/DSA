public class Order {
   public static void main(String[] args) {
      try {
         Scanner sc = new Scanner(System.in);
         System.out.print("Enter the name of the word lists text file: ");
         String fileName = sc.nextLine();
         
         Scanner fileSc = new Scanner(new File(fileName));
         
         while (fileSc.hasNextLine()) {
            String line = fileSc.nextLine();
            
            List<Integer> counts = new ArrayList<>();
            String[] words = line.toLowerCase().split(" ");
            int counter = 1;
            
            // Handle single word
            if (words.length == 1) {
               System.out.println("Longest is 1.");
            } else {
               // Loop through each word comparing with previous
               for (int i = 1; i < words.length; i++) {
                  if (words[i - 1].compareTo(words[i]) < 0) {
                     counter++;  // Continue sequence
                  } else {
                     counts.add(counter);  // Save sequence length
                     counter = 1;  // Reset for new sequence
                  }
               }
               
               // CRITICAL: Add the final sequence count
               counts.add(counter);
               
               // Find max
               int max = Collections.max(counts);
               
               // Count how many times max appears (DON'T remove first!)
               int maxCount = 0;
               for (Integer count : counts) {
                  if (count == max) {
                     maxCount++;
                  }
               }
               
               // Output result
               if (maxCount > 1) {
                  System.out.println("Multiple solutions length " + max + ".");
               } else {
                  System.out.println("Longest is " + max + ".");
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
}