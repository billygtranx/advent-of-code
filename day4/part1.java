import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/*
 * Attempts
 * 2447 - too low
 * 32001 - correct
 */

public class part1 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("input"))) {
            String line;
            int points = 0;
            while ((line = br.readLine()) != null) {
                // format of parts is always the same [Card, Winning Numbers, Ticket Numbers]
                // split line into parts regex to parse out case like `Card:  3` where there is more than one space
                List<String> parts = Arrays.asList(line.split("(:\\s+|\\s\\|\\s+)"));
                List<String> winning = Arrays.asList(parts.get(1).split("\\s+")).stream().sorted().toList();
                List<String> ticket = Arrays.asList(parts.get(2).split("\\s+")).stream().sorted().toList();
                List<String> matches = ticket.stream().filter(winning::contains).toList();

                int howMany = 0;
                howMany = (int) Math.pow(2, matches.size() - 1);
                System.out.println(howMany);
                points += howMany;
            }
            System.out.println("Total Points: " + points);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
