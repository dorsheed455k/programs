package cinema;

import java.util.Scanner;

 class Menu {

    public static String[][] theatre;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int rows, columns;

        System.out.println("Enter the number of rows: ");
        rows = in.nextInt();

        System.out.println("Enter the number of seats in each row:");
        columns = in.nextInt();

        theatre = new String[rows][columns];


        boolean terminate = false;
        setSets(rows, columns);
        do {
            int choice;
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "0. Exit");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    showSeats(rows, columns);
                    break;
                case 2:
                    int sR, sC;
                    System.out.println("Enter a row number: ");
                    sR = in.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    sC = in.nextInt();
                    buyTicket(sR, sC);
                    System.out.print("Ticket Price: ");
                    System.out.println("$" + ticketPrice(sR, sC, rows, columns));
                    break;
                case 0:
                    terminate = true;
                    break;
                default:
                    break;
            }
        } while (!terminate);


    }

    public static void showSeats(int r, int c) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= c; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        for (int i = 1; i <= r; i++) {
            System.out.print(i);
            for (int j = 1; j <= c; j++) {
                System.out.print(" " + theatre[i-1][j-1]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void setSets(int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                theatre[i][j] = "S";
            }
        }
    }

    public static void buyTicket(int sR, int sC) {
        for (int i = 0; i < theatre.length; i++) {
            for (int j = 0; j < theatre[i].length; j++) {
                if (i+1 == sR && j+1 == sC) {
                    theatre[i][j] = "B";
                }
            }
        }
    }

    public static int ticketPrice(int sR, int sC, int rows, int columns) {
        int seats = rows * columns;
        int ticket;
        if (seats < 60) {
            ticket = 10;
        } else {
            if(sR % 2 == 0) {
                if (sR <= rows/2) {
                    ticket = 10;
                } else {
                    ticket = 8;
                }
            } else {
                if (sR <= rows/2) {
                    ticket = 10;
                } else {
                    ticket = 8;
                }
            }
        }
        return ticket;
    }
}
