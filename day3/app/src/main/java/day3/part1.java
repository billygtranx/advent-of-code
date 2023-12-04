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
import java.util.stream.Collectors;

public class part1 {
    /*
     * attempted numbers:
     * 520739 too low
     * 849081 too high
     * 709892 too high
     * 606137 not right
     * 521601 correct
     */

    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/config.properties"));
            FileReader file = new FileReader(properties.getProperty("input"));
            BufferedReader reader = new BufferedReader(file);

            String[] specialChars = { "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "+", "=", "<", ">", "?",
                    "/", "|", "~", "`", ":", ";", "{", "}", "[", "]", "'", "\"", ",", "_", "\\" };

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
                    if (Arrays.asList(specialChars).contains(String.valueOf(charList.get(i)))) {
                        specialCharIndexes.add(i);
                    }
                }

                List<Integer> uniqueNumbersPerLine = new ArrayList<>();
                for (Integer index : specialCharIndexes) {
                    // Check the current line
                    if (index > 0 && Character.isDigit(currLine.charAt(index - 1))) {
                        uniqueNumbersPerLine.add(Integer.parseInt(extractNumber(currLine, index - 1)));
                    }
                    if (index < currLine.length() - 1 && Character.isDigit(currLine.charAt(index + 1))) {
                        uniqueNumbersPerLine.add(Integer.parseInt(extractNumber(currLine, index + 1)));
                    }
                    // Check the previous line
                    if (prevLine != null) {
                        boolean alreadyChecked = false;
                        if (index < prevLine.length() && Character.isDigit(prevLine.charAt(index))) {
                            uniqueNumbersPerLine.add(Integer.parseInt(extractNumber(prevLine, index)));
                            alreadyChecked = true;
                        }
                        if (!alreadyChecked && index > 0 && Character.isDigit(prevLine.charAt(index - 1))) {
                            uniqueNumbersPerLine.add(Integer.parseInt(extractNumber(prevLine, index - 1)));
                        }
                        if (!alreadyChecked && index < prevLine.length() - 1
                                && Character.isDigit(prevLine.charAt(index + 1))) {
                            uniqueNumbersPerLine.add(Integer.parseInt(extractNumber(prevLine, index + 1)));
                        }
                    }
                    // Check the next line
                    if (nextLine != null) {
                        boolean alreadyChecked = false;
                        if (index < nextLine.length() && Character.isDigit(nextLine.charAt(index))) {
                            uniqueNumbersPerLine.add(Integer.parseInt(extractNumber(nextLine, index)));
                            alreadyChecked = true;
                        }
                        if (!alreadyChecked && index > 0 && Character.isDigit(nextLine.charAt(index - 1))) {
                            uniqueNumbersPerLine.add(Integer.parseInt(extractNumber(nextLine, index - 1)));
                        }
                        if (!alreadyChecked && index < nextLine.length() - 1
                                && Character.isDigit(nextLine.charAt(index + 1))) {
                            uniqueNumbersPerLine.add(Integer.parseInt(extractNumber(nextLine, index + 1)));
                        }
                    }
                }
                numbers.addAll(uniqueNumbersPerLine.stream().map(String::valueOf).collect(Collectors.toList()));
                uniqueNumbersPerLine.clear();

            }
            System.out.println(numbers.stream().mapToInt(Integer::parseInt).sum());
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
