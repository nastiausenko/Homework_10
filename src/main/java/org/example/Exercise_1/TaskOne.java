package org.example.Exercise_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskOne {
    public static void main(String[] args) {
        File file = new File("textFiles/file.txt");

        try(FileInputStream fis = new FileInputStream(file);
            Scanner scanner = new Scanner(fis)) {
            Pattern phonePattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}|\\(\\d{3}\\)\\s\\d{3}-\\d{4}");

            while (scanner.hasNext()){
                String number = scanner.nextLine();
                Matcher matcher = phonePattern.matcher(number);
                if (matcher.matches()) {
                    System.out.println(number);
                }
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
