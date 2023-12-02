package com.example.day1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class part2 {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("day1/day1/src/main/resources/config.properties"));

            FileReader file = new FileReader(properties.getProperty("input"));
            BufferedReader reader = new BufferedReader(file);

            String line;
            int total = 0;
            while ((line = reader.readLine()) != null) {
                Map<String, String> lookup = new HashMap<>();
                lookup.put("one", "1");
                lookup.put("two", "2");
                lookup.put("three", "3");
                lookup.put("four", "4");
                lookup.put("five", "5");
                lookup.put("six", "6");
                lookup.put("seven", "7");
                lookup.put("eight", "8");
                lookup.put("nine", "9");
                lookup.put("oneight", "8");
                lookup.put("sevenine", "9");
                lookup.put("eighthree", "3");
                lookup.put("fiveight", "8");
                Pattern firstDigitPattern = Pattern
                        .compile(
                                "(\\d|oneight|twone|threeight|fiveight|sevenine|eighthree|eightwo|one|two|three|four|five|six|seven|eight|nine)");
                Matcher match = firstDigitPattern.matcher(line);
                List<String> numbers = new ArrayList<>();
                while (match.find()) {
                    numbers.add(match.group(1));
                }

                String first;
                String last;

                switch (numbers.getFirst()) {
                    case "oneight":
                        first = "1";
                        break;
                    case "eightwo":
                        first = "8";
                        break;
                    case "threeight":
                        first = "3";
                        break;
                    case "fiveight":
                        first = "5";
                        break;
                    case "sevenine":
                        first = "7";
                        break;
                    case "eighthree":
                        first = "8";
                        break;
                    case "twone":
                        first = "2";
                        break;
                    default:
                        first = (numbers.getFirst().length() < 2) ? numbers.getFirst() : lookup.get(numbers.getFirst());
                        break;
                }

                switch (numbers.getLast()) {
                    case "oneight":
                        last = "8";
                        break;
                    case "eightwo":
                        last = "2";
                        break;
                    case "threeight":
                        last = "8";
                        break;
                    case "fiveight":
                        last = "8";
                        break;
                    case "sevenine":
                        last = "9";
                        break;
                    case "eighthree":
                        last = "3";
                        break;
                    case "twone":
                        last = "1";
                        break;
                    default:
                        last = (numbers.getLast().length() < 2) ? numbers.getLast() : lookup.get(numbers.getLast());
                        break;
                }

                int value = Integer.parseInt(first + last);
                total += value;
            }

            System.out.println(total);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

/*
 * attempts:
 * 57353
 * 57345 Correct
 */