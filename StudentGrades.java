import java.util.ArrayList;
import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> grades = new ArrayList<>();
        ArrayList<Double> numericGrades = new ArrayList<>();

        System.out.println("Enter student grades (A, B, C, D, F). Type 'stop' to finish:");

        while (true) {
            String grade = scanner.next().toUpperCase(); // Convert to uppercase for consistency
            if (grade.equals("STOP")) break; // Stop input if "STOP" is entered
            
            double numericValue = getNumericValue(grade);
            if (numericValue == -1) {
                System.out.println("Invalid grade entered. Please enter A, B, C, D, or F.");
            } else {
                grades.add(grade);
                numericGrades.add(numericValue);
            }
        }

        if (grades.isEmpty()) {
            System.out.println("No grades entered.");
        } else {
            double sum = 0, highest = numericGrades.get(0), lowest = numericGrades.get(0);

            for (double numGrade : numericGrades) {
                sum += numGrade;
                if (numGrade > highest) highest = numGrade;
                if (numGrade < lowest) lowest = numGrade;
            }

            double average = sum / numericGrades.size();

            System.out.println("Average Score: " + getLetterGrade(average));
            System.out.println("Highest Score: " + getLetterGrade(highest));
            System.out.println("Lowest Score: " + getLetterGrade(lowest));
        }

        scanner.close();
    }

    // Convert letter grades to numeric values
    public static double getNumericValue(String grade) {
        switch (grade) {
            case "A": return 90;
            case "B": return 80;
            case "C": return 70;
            case "D": return 60;
            case "F": return 50;
            default: return -1; // Invalid grade
        }
    }

    // Convert numeric values back to letter grades
    public static String getLetterGrade(double numeric) {
        if (numeric >= 90) return "A";
        else if (numeric >= 80) return "B";
        else if (numeric >= 70) return "C";
        else if (numeric >= 60) return "D";
        else return "F";
    }
}
