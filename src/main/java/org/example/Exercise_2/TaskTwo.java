package org.example.Exercise_2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args) {
        File file = new File("textFiles/fileTwo.txt");
        File outputFile = new File("textFiles/user.json");

        try(FileInputStream fis = new FileInputStream(file);
            Scanner scanner = new Scanner(fis);
            FileOutputStream fos = new FileOutputStream(outputFile);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos))) {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            List<User> users = new ArrayList<>();

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNext()){
                String line = scanner.nextLine();
                String[] userField = line.split(" ");

                String name = userField[0];
                Integer age = Integer.valueOf(userField[1]);
                User user = new User(name, age);
                users.add(user);
            }

            String json = gson.toJson(users);
            writer.write(json);

        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
