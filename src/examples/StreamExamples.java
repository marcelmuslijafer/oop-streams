package examples;

import examples.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
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
                                          .map(student -> student.getStudentID())
                                          .collect(Collectors.toList());
        System.out.println(studentIDs);
        System.out.println("\n");

        // Example 3: sorted(Comparator<T> comparator) - Sort students by last name
        System.out.println("Example 3: Sort students by last name");
        List<Student> sortedStudents = students.stream()
                                               .sorted(Student.BY_LAST_NAME.reversed())
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
                                      .map(student -> student.getFirstName())
                                      .collect(Collectors.joining(", "));
        System.out.println(studentNames);
        System.out.println("\n");

        // Example 9: reduce(T identity, BinaryOperator<T> accumulator) - Calculate the total points of students
        System.out.println("Example 9: Calculate the total points of students");
        int totalPoints = students.stream()
                                  .map(student -> student.getPoints())
                                  .reduce(0, (num1, num2) -> num1 + num2);
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
                .filter(student -> student.getLastName().length() > 4)
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
                                               .max(Student.BY_POINTS.thenComparing(Student.BY_FIRST_NAME));
        System.out.println(maxStudent.orElse(null));
        System.out.println("\n");

        // Example 18: toArray() - Convert the stream into an array
        System.out.println("Example 18: Convert the stream into an array");
        Student[] studentArray = students.stream()
                                         .toArray(Student[]::new);
        System.out.println(Arrays.toString(studentArray));
        System.out.println("\n");

        // Example 19: mapToInt() - Get average points
        System.out.println("Example 19: Get average points");
        double average = students.stream()
                .mapToInt(student -> student.getPoints())
                .average()
                .getAsDouble();
        System.out.println(average);
        System.out.println("\n");

        // Example 20: groupingBy() - Get a map that stores name lengths as keys,
        // and a number of students with a certain name length as values
        // e.g. 6 -> 3 if there are 3 students with names of length 3
        System.out.println("Example 20: Get name length counts");
        Map<Integer, Long> nameLengthCounts = students.stream()
                .collect(Collectors.groupingBy(student -> student.getFirstName().length(), Collectors.counting()));
        System.out.println(nameLengthCounts);
        System.out.println("\n");

        // Example 21: groupingBy() - Get a map that contains counts of students that belong to a certain point range
        // For example if the point range is 30:
        // 0 -> 5 means that there are 5 students that have between 0 and 30 points
        // 30 -> 3 means that there are 3 students that have between 30 and 60 points, and so on
        System.out.println("Example 21: Group by points");
        int range = 30;
        Map<Integer, Long> histogram = students.stream()
                .collect(Collectors.groupingBy(student -> (student.getPoints() / range) * range, Collectors.counting()));

        System.out.println(histogram);
    }
}
