package org.example.Exercise_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

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

            List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordFrequency.entrySet());
            wordList.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return (o2.getValue().compareTo(o1.getValue()));
                }
            });

            for (Map.Entry<String, Integer> entry: wordList) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }

        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
