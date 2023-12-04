package day3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/* attempted numbers:
 * 7940078 too low
 * 80694070 correct
 */
public class part2 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/config.properties"));
            FileReader file = new FileReader(properties.getProperty("input"));
            BufferedReader reader = new BufferedReader(file);

            String prevLine = null;
            String currLine = null;
            String nextLine = reader.readLine();
            List<String> numbers = new ArrayList<>();

            while (nextLine != null) {
                prevLine = currLine;
                currLine = nextLine;
                nextLine = reader.readLine();

                List<Character> charList = currLine.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toList());

                List<Integer> specialCharIndexes = new ArrayList<>();
                for (int i = 0; i < charList.size(); i++) {
                    if (charList.get(i) == '*') {
                        specialCharIndexes.add(i);
                    }
                }

                for (Integer index : specialCharIndexes) {
                    List<String> numbersNextToGears = new ArrayList<>();
                    // Check the current line
                    if (index > 0 && Character.isDigit(currLine.charAt(index - 1))) {
                        numbersNextToGears.add(extractNumber(currLine, index - 1));
                    }
                    if (index < currLine.length() - 1 && Character.isDigit(currLine.charAt(index + 1))) {
                        numbersNextToGears.add(extractNumber(currLine, index + 1));
                    }
                    // Check the previous line
                    if (prevLine != null) {
                        boolean alreadyChecked = false;
                        if (index < prevLine.length() && Character.isDigit(prevLine.charAt(index))) {
                            numbersNextToGears.add(extractNumber(prevLine, index));
                            alreadyChecked = true;
                        }
                        if (!alreadyChecked && index > 0 && Character.isDigit(prevLine.charAt(index - 1))) {
                            numbersNextToGears.add(extractNumber(prevLine, index - 1));
                        }
                        if (!alreadyChecked && index < prevLine.length() - 1
                                && Character.isDigit(prevLine.charAt(index + 1))) {
                            numbersNextToGears.add(extractNumber(prevLine, index + 1));
                        }
                    }
                    // Check the next line
                    if (nextLine != null) {
                        boolean alreadyChecked = false;
                        if (index < nextLine.length() && Character.isDigit(nextLine.charAt(index))) {
                            numbersNextToGears.add(extractNumber(nextLine, index));
                            alreadyChecked = true;
                        }
                        if (!alreadyChecked && index > 0 && Character.isDigit(nextLine.charAt(index - 1))) {
                            numbersNextToGears.add(extractNumber(nextLine, index - 1));
                        }
                        if (!alreadyChecked && index < nextLine.length() - 1
                                && Character.isDigit(nextLine.charAt(index + 1))) {
                            numbersNextToGears.add(extractNumber(nextLine, index + 1));
                        }
                    }

                    if (numbersNextToGears.size() == 2) {
                        int firstNumber = Integer.parseInt(numbersNextToGears.get(0));
                        int secondNumber = Integer.parseInt(numbersNextToGears.get(1));
                        numbers.add(String.valueOf(firstNumber * secondNumber));
                    }
                }

            }
            int sum = numbers.stream()
                    .mapToInt(Integer::parseInt)
                    .sum();

            System.out.println(sum);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String extractNumber(String line, int index) {
        int start = index;
        while (start > 0 && Character.isDigit(line.charAt(start - 1))) {
            start--;
        }
        int end = index;
        while (end < line.length() - 1 && Character.isDigit(line.charAt(end + 1))) {
            end++;
        }
        return line.substring(start, end + 1);
    }
}
