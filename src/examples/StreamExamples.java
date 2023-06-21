package examples;

import examples.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamExamples {

    public static void main(String[] args) {
        List<Student> students = StudentData.load();

        // Example 1: filter(Predicate<T> predicate) - Filter students with more than 40 points
        System.out.println("Example 1: Filter students with more than 40 points");
        List<Student> filteredStudents = students.stream()
                                                 .filter(student -> student.getPoints() > 40)
                                                 .collect(Collectors.toList());
        System.out.println(filteredStudents);
        System.out.println("\n");

        // Example 2: map(Function<T, R> mapper) - Get a list of student IDs
        System.out.println("Example 2: Get a list of student IDs");
        List<String> studentIDs = students.stream()
                                          .map(Student::getStudentID)
                                          .collect(Collectors.toList());
        System.out.println(studentIDs);
        System.out.println("\n");

        // Example 3: sorted(Comparator<T> comparator) - Sort students by last name
        System.out.println("Example 3: Sort students by last name");
        List<Student> sortedStudents = students.stream()
                                               .sorted(Student.BY_LAST_NAME)
                                               .collect(Collectors.toList());
        System.out.println(sortedStudents);
        System.out.println("\n");

        // Example 4: distinct() - Get distinct student last names
        System.out.println("Example 4: Get distinct student last names");
        List<String> distinctLastNames = students.stream()
                                                 .map(Student::getLastName)
                                                 .distinct()
                                                 .collect(Collectors.toList());
        System.out.println(distinctLastNames);
        System.out.println("\n");

        // Example 5: limit(long maxSize) - Limit the number of students in the stream
        System.out.println("Example 5: Limit the number of students in the stream");
        List<Student> limitedStudents = students.stream()
                                                 .limit(3)
                                                 .collect(Collectors.toList());
        System.out.println(limitedStudents);
        System.out.println("\n");

        // Example 6: skip(long n) - Skip the first n students in the stream
        System.out.println("Example 6: Skip the first n students in the stream");
        List<Student> skippedStudents = students.stream()
                                                 .skip(2)
                                                 .collect(Collectors.toList());
        System.out.println(skippedStudents);
        System.out.println("\n");

        // Example 7: forEach(Consumer<T> action) - Print the first names of students
        System.out.println("Example 7: Print the first names of students");
        students.stream()
                .forEach(student -> System.out.println(student.getFirstName()));
        System.out.println("\n");

        // Example 8: collect(Collector<T, A, R> collector) - Join student names into a single string
        System.out.println("Example 8: Join student names into a single string");
        String studentNames = students.stream()
                                      .map(Student::getFirstName)
                                      .collect(Collectors.joining(", "));
        System.out.println(studentNames);
        System.out.println("\n");

        // Example 9: reduce(T identity, BinaryOperator<T> accumulator) - Calculate the total points of students
        System.out.println("Example 9: Calculate the total points of students");
        int totalPoints = students.stream()
                                  .map(Student::getPoints)
                                  .reduce(0, Integer::sum);
        System.out.println("Total points: " + totalPoints);
        System.out.println("\n");

        // Example 10: allMatch(Predicate<T> predicate) - Check if all students passed
        System.out.println("Example 10: Check if all students passed");
        boolean allPassed = students.stream()
                                    .allMatch(student -> student.getPoints() >= 40);
        System.out.println("All students passed: " + allPassed);
        System.out.println("\n");

        // Example 11: anyMatch(Predicate<T> predicate) - Check if any student passed
        System.out.println("Example 11: Check if any student passed");
        boolean anyPassed = students.stream()
                                    .anyMatch(student -> student.getPoints() >= 40);
        System.out.println("Any student passed: " + anyPassed);
        System.out.println("\n");

        // Example 12: noneMatch(Predicate<T> predicate) - Check if no student failed
        System.out.println("Example 12: Check if no student failed");
        boolean noneFailed = students.stream()
                                     .noneMatch(student -> student.getPoints() < 40);
        System.out.println("No student failed: " + noneFailed);
        System.out.println("\n");

        // Example 13: findFirst() - Get the first student in the stream
        System.out.println("Example 13: Get the first student in the stream");
        Optional<Student> firstStudent = students.stream()
                                                 .findFirst();
        System.out.println(firstStudent.orElse(null));
        System.out.println("\n");

        // Example 14: findAny() - Get any student in the stream
        System.out.println("Example 14: Get any student in the stream");
        Optional<Student> anyStudent = students.stream()
                                               .findAny();
        System.out.println(anyStudent.orElse(null));
        System.out.println("\n");

        // Example 15: count() - Count the number of students
        System.out.println("Example 15: Count the number of students");
        long count = students.stream()
                             .count();
        System.out.println("Number of students: " + count);
        System.out.println("\n");

        // Example 16: min(Comparator<T> comparator) - Get the student with the minimum points
        System.out.println("Example 16: Get the student with the minimum points");
        Optional<Student> minStudent = students.stream()
                                               .min(Student.BY_POINTS);
        System.out.println(minStudent.orElse(null));
        System.out.println("\n");

        // Example 17: max(Comparator<T> comparator) - Get the student with the maximum points
        System.out.println("Example 17: Get the student with the maximum points");
        Optional<Student> maxStudent = students.stream()
                                               .max(Student.BY_POINTS);
        System.out.println(maxStudent.orElse(null));
        System.out.println("\n");

        // Example 18: toArray() - Convert the stream into an array
        System.out.println("Example 18: Convert the stream into an array");
        Student[] studentArray = students.stream()
                                         .toArray(Student[]::new);
        System.out.println(Arrays.toString(studentArray));
    }
}