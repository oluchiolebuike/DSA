import java.io.*;
import java.util.*;

public class Bump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the filename:");
        String filename = sc.nextLine().trim();

        try {
            Scanner fileScanner = new Scanner(new File(filename));

            // Stores bot name -> energy value
            HashMap<String, Integer> botEnergy = new HashMap<>();

            // Stores bump pairs (who bumps who)
            List<String[]> bumps = new ArrayList<>();

            // Read lines from the file
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");

                // If it's a bot energy line, e.g. "Turbot 49"
                if (parts.length == 2 && Character.isDigit(parts[1].charAt(0))) {
                    String botName = parts[0];
                    int energy = Integer.parseInt(parts[1]);
                    botEnergy.put(botName, energy);
                }
                // If it's a bump line, e.g. "Turbot Botfly"
                else if (parts.length == 2) {
                    bumps.add(parts);
                }
            }

            // Process each bump interaction
            for (String[] bump : bumps) {
                String bi = bump[0];
                String bj = bump[1];

                // Skip if bots aren't in the map
                if (!botEnergy.containsKey(bi) || !botEnergy.containsKey(bj)) continue;

                int N = botEnergy.get(bi);
                int M = botEnergy.get(bj);

                // Apply bump rules
                if (N > M && N >= 5) {
                    N -= 5;
                    M += 5;
                } else if (N > M && N < 5) {
                    M += N;
                    N = 0;
                } else if (N < M && M >= 5) {
                    M -= 5;
                    N += 5;
                } else if (N < M && M < 5) {
                    N += M;
                    M = 0;
                }

                // Update energies
                botEnergy.put(bi, N);
                botEnergy.put(bj, M);
            }

            // Print final energies
            System.out.println("\nFinal energy levels:");
            for (Map.Entry<String, Integer> entry : botEnergy.entrySet()) {
                System.out.printf("%-10s : %d%n", entry.getKey(), entry.getValue());
            }

            System.out.println("\nDone.");

            sc.close();
            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
