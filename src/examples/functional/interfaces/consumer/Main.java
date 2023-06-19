package examples.functional.interfaces.consumer;

import examples.functional.interfaces.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        // Example - Print the given string
        Consumer<String> printString = str -> System.out.println(str);

        // TODO: Task 1 - Print the length of the given list

        // TODO: Task 2 - Print the given person

        // TODO: Task 3 - Log the given error message to a log file

        // TODO: Task 4 - Store the given product to a file
    }
}
