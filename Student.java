package CodeSoft;

import java.util.ArrayList;
import java.util.List;

class Student {
    int studentID;
    String name;
    List<String> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
}
