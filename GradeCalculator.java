package CodeSoft;
import java.util.Scanner;

	public class GradeCalculator {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter the number of subjects:");
	        int numberOfSubjects = scanner.nextInt();

	        // Validate the number of subjects
	        if (numberOfSubjects <= 0) {
	            System.out.println("Invalid number of subjects. Please enter a positive number.");
	            return;
	        }

	        int totalMarks = 0;

	        // Take marks for each subject
	        for (int i = 1; i <= numberOfSubjects; i++) {
	            System.out.println("Enter marks for subject " + i + " (out of 100):");
	            int marks = scanner.nextInt();

	            // Validate the marks
	            if (marks < 0 || marks > 100) {
	                System.out.println("Invalid marks. Please enter marks between 0 and 100.");
	                return;
	            }

	            totalMarks += marks;
	        }

	        // Calculate total marks and average percentage
	        double averagePercentage = (double) totalMarks / numberOfSubjects;

	        // Assign grades based on the average percentage
	        char grade;
	        if (averagePercentage >= 90) {
	            grade = 'A';
	        } else if (averagePercentage >= 80) {
	            grade = 'B';
	        } else if (averagePercentage >= 75) {
	            grade = 'C';
	        } else if (averagePercentage >= 65) {
	            grade = 'D';
	        } else {
	            grade = 'F';
	        }

	        // Display results
	        System.out.println("\nResults:");
	        System.out.println("Total Marks: " + totalMarks);
	        System.out.println("Average Percentage: " + averagePercentage + "%");
	        System.out.println("Grade: " + grade);

	        scanner.close();
	    }
	}


