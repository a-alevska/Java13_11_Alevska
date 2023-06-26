package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    public List<Names> getNamesList(){
        List<Names> namesList = new ArrayList<>();
        try {
            File file = new File("names.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(" ");

                int index = Integer.parseInt(data[0]);
                String name = data[1];

                Names names = new Names(index, name);
                namesList.add(names);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return namesList;
    }

    public static void main(String[] args) {
        Task1 t = new Task1();
        List<Names> names = t.getNamesList();
        Stream<Names> namesStream = names.stream()
                .filter(index -> index.getIndex()%2!=0);
        List<Names> filteredNames = namesStream.collect(Collectors.toList());
        System.out.println(filteredNames);
    }

}
