package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2{
    public List<String> getNamesList(){
        List<String> namesList = new ArrayList<>();
        try {
            File file = new File("names.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(" ");

                String name = data[1];

                namesList.add(name);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return namesList;
    }

    public static void main(String[] args) {
        Task2 t = new Task2();
        List<String> names = t.getNamesList();
        Stream<String> namesStream = names.stream()
                .map (String::toUpperCase)
                .sorted(Comparator.reverseOrder());
        System.out.println(namesStream.collect(Collectors.toList()));
    }
}
