package com.example.day1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Pattern;

public class part1 {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("day1/day1/src/main/resources/config.properties"));

            FileReader file = new FileReader(properties.getProperty("input"));
            BufferedReader reader = new BufferedReader(file);

            String line;
            int total = 0;
            while ((line = reader.readLine()) != null) {
                Pattern firstDigitPattern = Pattern.compile("[A-Za-z]");
                String[] numbers = firstDigitPattern.split(line);
                StringBuilder lineOfNumbers = new StringBuilder();
                for (String num : numbers){
                    if(!num.isEmpty()){
                        lineOfNumbers.append(num);
                    }
                }
                String firstDigit = Character.toString(lineOfNumbers.toString().charAt(0));
                String lastDigit = Character.toString(lineOfNumbers.toString().charAt(lineOfNumbers.length() - 1));
                int value = Integer.parseInt(firstDigit + lastDigit);
                total += value;
            }

            System.out.println(total);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
