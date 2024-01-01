package CodeSoft;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class CourseRegistrationSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        // Adding sample courses
        courses.add(new Course("CS101", "Introduction to Computer Science", "Basic CS concepts", 30, "Mon, Wed 9:00 AM"));
        courses.add(new Course("MATH201", "Calculus I", "Limits and derivatives", 25, "Tue, Thu 10:30 AM"));

        // Main menu
        while (true) {
            System.out.println("\nCourse Registration System");
            System.out.println("1. View Course Listing");
            System.out.println("2. Student Registration");
            System.out.println("3. Course Removal");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayCourseListing(courses);
                    break;
                case 2:
                    performStudentRegistration(scanner, students, courses);
                    break;
                case 3:
                    performCourseRemoval(scanner, students);
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private static void displayCourseListing(List<Course> courses) {
        System.out.println("\nCourse Listing:");
        for (Course course : courses) {
            System.out.println("Course Code: " + course.courseCode);
            System.out.println("Title: " + course.title);
            System.out.println("Description: " + course.description);
            System.out.println("Capacity: " + course.capacity);
            System.out.println("Schedule: " + course.schedule);
            System.out.println("Available Slots: " + (course.capacity - getRegisteredStudentsCount(course.courseCode)));
            System.out.println();
        }
    }

    private static void performStudentRegistration(Scanner scanner, List<Student> students, List<Course> courses) {
        System.out.print("Enter Student ID: ");
        int studentID = scanner.nextInt();

        System.out.print("Enter Student Name: ");
        String studentName = scanner.next();

        Student student = new Student(studentID, studentName);
        students.add(student);

        displayCourseListing(courses);

        System.out.print("Enter Course Code to Register: ");
        String courseCodeToRegister = scanner.next();

        Course selectedCourse = findCourseByCode(courses, courseCodeToRegister);

        if (selectedCourse != null && !isCourseFull(selectedCourse)) {
            student.registeredCourses.add(courseCodeToRegister);
            System.out.println("Registration successful for course: " + courseCodeToRegister);
        } else {
            System.out.println("Course registration failed. The course is full or doesn't exist.");
        }
    }

    private static void performCourseRemoval(Scanner scanner, List<Student> students) {
        System.out.print("Enter Student ID for Course Removal: ");
        int studentID = scanner.nextInt();

        Student student = findStudentByID(students, studentID);

        if (student != null && !student.registeredCourses.isEmpty()) {
            System.out.println("Student " + student.name + " is registered in the following courses:");

            for (String courseCode : student.registeredCourses) {
                System.out.println(courseCode);
            }

            System.out.print("Enter Course Code to Remove: ");
            String courseCodeToRemove = scanner.next();

            if (student.registeredCourses.contains(courseCodeToRemove)) {
                student.registeredCourses.remove(courseCodeToRemove);
                System.out.println("Course removal successful for course: " + courseCodeToRemove);
            } else {
                System.out.println("Course removal failed. The student is not registered in the specified course.");
            }
        } else {
            System.out.println("Course removal failed. Student not found or not registered in any courses.");
        }
    }

    private static Course findCourseByCode(List<Course> courses, String courseCode) {
        for (Course course : courses) {
            if (course.courseCode.equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    private static Student findStudentByID(List<Student> students, int studentID) {
        for (Student student : students) {
            if (student.studentID == studentID) {
                return student;
            }
        }
        return null;
    }

    private static int getRegisteredStudentsCount(String courseCode) {
        // For simplicity, this method assumes that each course is unique, and students can only register once.
        return 0;
    }

    private static boolean isCourseFull(Course course) {
        return getRegisteredStudentsCount(course.courseCode) >= course.capacity;
    }
}