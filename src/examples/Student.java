package examples;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

public class Student implements Comparable<Student> {

    private String lastName;
    private String firstName;
    private String studentID;
    private int points;

    private static Comparator<Object> hrcomparator = Collator.getInstance(Locale.forLanguageTag("hr"));

    public static final Comparator<Student> BY_LAST_NAME =
            (s1, s2) -> hrcomparator.compare(s1.lastName, s2.lastName);

    public static final Comparator<Student> BY_FIRST_NAME =
            (s1, s2) -> hrcomparator.compare(s1.firstName, s2.firstName);

    public static final Comparator<Student> BY_STUDENT_ID =
            (s1, s2) -> hrcomparator.compare(s1.studentID, s2.studentID);

    public static final Comparator<Student> BY_POINTS =
            (s1, s2) -> Integer.compare(s1.points, s2.points);

    // Constructor
    public Student(String lastName, String firstName, String studentID, int points) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.studentID = studentID;
        this.points = points;
    }

    @Override
    public int compareTo(Student other) {
        return BY_STUDENT_ID.compare(this, other);
    }

    @Override
    public String toString() {
        return String.format("(%s) %s %s - %d", studentID, firstName, lastName, points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return points == student.points &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(studentID, student.studentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, studentID, points);
    }

    // Getters
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getStudentID() {
        return studentID;
    }

    public int getPoints() {
        return points;
    }
}