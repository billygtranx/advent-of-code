import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*
 * Attempts
 * 1258 - too low
 */

public class part2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("input"))) {
            String line;
            int cards = 0;
            List<Integer> additionalCards = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("(:\\s+|\\s\\|\\s+)");
                String[] winning = parts[1].split("\\s+");
                String[] ticket = parts[2].split("\\s+");
                int howMany = Arrays.asList(ticket).stream().filter(Arrays.asList(winning)::contains).toList().size();
                int additionalAttempts = 0;
                if (!additionalCards.isEmpty()) {
                    additionalAttempts = additionalCards.remove(0);
                }
                cards += 1 + additionalAttempts;
                for (int i = 0; i <= additionalAttempts; i++) {
                    for (int j = 0; j < howMany; j++) {
                        if (additionalCards.size() <= j) {
                            additionalCards.add(1);
                        } else {
                            additionalCards.set(j, additionalCards.get(j) + 1);
                        }
                    }
                }
            }
            System.out.println("Total Cards: " + cards);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
