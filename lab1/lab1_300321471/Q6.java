import java.util.Arrays;
import java.util.Scanner;

public class Q6 {

    public static void main(String[] args) {
        int sizeClass = 10;
        double[] grades;
        Scanner sc;

        grades = new double[sizeClass];
        sc = new Scanner(System.in);

        for (int i = 0; i < sizeClass; i++) {
            System.out.println("Please enter the grade of student " + (i + 1) + ":");
            grades[i] = sc.nextDouble();
        }

        System.out.println("The average is " + calculateAverage(grades));
        System.out.println("The median is " + calculateMedian(grades));
        System.out.println("The number of failed grades is " + calculateNumberFailed(grades));
        System.out.println("The number of passed grades is " + calculateNumberPassed(grades));
    }

    public static double calculateAverage(double[] notes) {
        double total = 0;
        double result = 0;

        for (int i = 0; i < notes.length; i++) {
            total += notes[i];
        }

        result = total / notes.length;

        return result;
    }

    public static double calculateMedian(double[] notes) {
        Arrays.sort(notes); // Sort the array in ascending order

        int middleIndex = notes.length / 2;
        double result;

        if (notes.length % 2 == 0) {
            result = (notes[middleIndex - 1] + notes[middleIndex]) / 2.0;
        } else {
            result = notes[middleIndex];
        }

        return result;
    }

    public static int calculateNumberFailed(double[] notes) {
        int numberOfFailedGrades = 0;

        for (int i = 0; i < notes.length; i++) {
            if (notes[i] < 50) {
                numberOfFailedGrades++;
            }
        }

        return numberOfFailedGrades;
    }

    public static int calculateNumberPassed(double[] notes) {
        int numberOfPassedGrades = 0;

        for (int i = 0; i < notes.length; i++) {
            if (notes[i] >= 50) {
                numberOfPassedGrades++;
            }
        }

        return numberOfPassedGrades;
    }
}
