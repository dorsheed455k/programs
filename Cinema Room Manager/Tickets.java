package cinema;

import java.util.Scanner;

 class Tickets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows, columns;
        int r, c;

        System.out.println("Enter the number of rows:");
        rows = in.nextInt();

        System.out.println("Enter the number of seats in each row:");
        columns = in.nextInt();
        System.out.println();

        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= columns; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        for (int i = 1; i <= rows; i++) {
            System.out.print(i);
            for (int j = 1; j <= columns; j++) {
                System.out.print(" S");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Enter a row number:");
        r = in.nextInt();

        System.out.println("Enter a seat number in that row:");
        c = in.nextInt();
        System.out.println();

        int seats = rows * columns;
        int income = 0;
        int ticket = 0;
        if (seats < 60) {
            income = seats * 10;
            ticket = 10;
        } else {
            int front;
            int back;
            int section = r*c;
            if(r % 2 == 0) {
                if (r <= rows/2) {
                    ticket = 10;
                } else {
                    ticket = 8;
                }
            } else {
                if (r <= rows/2) {
                    ticket = 10;
                } else {
                    ticket = 8;
                }
            }
        }

        System.out.print("Ticket Price: ");
        System.out.println("$" + ticket + "\n");

        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= columns; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        for (int i = 1; i <= rows; i++) {
            System.out.print(i);
            for (int j = 1; j <= columns; j++) {
                if (i == r && j == c) {
                    System.out.print(" B");
                } else {
                    System.out.print(" S");
                }
            }
            System.out.println();
        }
    }
}
