package org.example.Exercise_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskThree {

    public static void main(String[] args) {
        File file = new File("textFiles/words.txt");

        try(FileInputStream fis = new FileInputStream(file);
            Scanner scanner = new Scanner(fis)){
            Map<String, Integer> wordFrequency = new HashMap<>();
            
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                String[] words = line.split("\\s+");

                for (String word: words) {
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }

            for (Map.Entry<String, Integer> entry: wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }

        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
