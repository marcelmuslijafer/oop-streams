package examples;

import java.util.ArrayList;
import java.util.List;

public class StudentData {

    public static List<Student> load() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Anić", "Anica", "0000000001", 30));
        list.add(new Student("Banić", "Banica", "0000000002", 40));
        list.add(new Student("Štefić", "Štefica", "0000000003", 50));
        list.add(new Student("Anić", "Ante", "0000000004", 40));
        list.add(new Student("Ivić", "Ivo", "0000000005", 30));
        list.add(new Student("Perić", "Perica", "0000000006", 50));
        list.add(new Student("Zenić", "Zanatea", "0000000007", 50));
        list.add(new Student("Renić", "Renato", "0000000008", 50));
        return list;
    }
}
