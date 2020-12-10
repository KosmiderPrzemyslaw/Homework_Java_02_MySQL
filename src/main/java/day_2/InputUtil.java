package day_2;

import java.util.Scanner;

public class InputUtil {
    public static String askUser(String prompt) {
        System.out.println(prompt);

        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static int askForValidNumber(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Incorrect value!");
            System.out.println(prompt);

        }
        return scanner.nextInt();
    }
}
