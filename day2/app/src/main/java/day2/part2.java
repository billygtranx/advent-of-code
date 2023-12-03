package day2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class part2 {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("app/src/main/resources/config.properties"));

            FileReader file = new FileReader(properties.getProperty("input"));
            BufferedReader reader = new BufferedReader(file);
            String line;
            int total = 0;
            while ((line = reader.readLine()) != null) {
                int redMin = 0;
                int greenMin = 0;
                int blueMin = 0;
                int power = 0;
                List<String> splitLine = new ArrayList<>();
                splitLine = Arrays.asList(line.split(":|;|,"));
                Pattern numbersPattern = Pattern.compile("\\d+");

                for (String str : splitLine) {
                    Matcher numbersMatcher = numbersPattern.matcher(str);
                    if (numbersMatcher.find()) {
                        if (str.contains("red")) {
                            redMin = (redMin > Integer.parseInt(numbersMatcher.group())) ? redMin : Integer.parseInt(numbersMatcher.group());
                        }
                        if (str.contains("green")) {
                            greenMin = (greenMin > Integer.parseInt(numbersMatcher.group())) ? greenMin : Integer.parseInt(numbersMatcher.group());
                        }
                        if (str.contains("blue")) {
                            blueMin =  (blueMin > Integer.parseInt(numbersMatcher.group())) ? blueMin : Integer.parseInt(numbersMatcher.group());
                        }
                    }
                }
                power = redMin * greenMin * blueMin;
                total += power;
            }
            System.out.println(" total: " + total);
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
