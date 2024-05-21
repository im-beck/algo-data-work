package Assignments;
import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of temperatures: ");
        int n = scanner.nextInt();

        int[] temperatures = new int[n];
        System.out.println("Enter the temperatures:");

        for (int i = 0; i < n; i++) {
            temperatures[i] = scanner.nextInt();
        }

        int sum = 0;
        for (int temperature : temperatures) {
            sum += temperature;
        }

        double average = (double) sum / n;
        System.out.println("Average temperature: " + average);

        int countAboveAverage = 0;
        for (int temperature : temperatures) {
            if (temperature > average) {
                countAboveAverage++;
            }
        }

        System.out.println("Number of temperatures above average: " + countAboveAverage);

        scanner.close();
    }
}