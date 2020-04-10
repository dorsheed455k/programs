package Classescom.company;

import java.util.Scanner;

public class Tofer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String name = in.next();

        if (name == null) {
            System.out.println("One for you, one for me");
        } else {
            System.out.printf("One for %s, one for me", name);
        }

    }
}
