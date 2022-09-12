package cinema;

import java.util.Scanner;

class Error {

    public static String[][] theatre;
    public static Scanner in;
    public static int sR, sC;
    public static void main(String[] args) {
        in = new Scanner(System.in);

        int rows, columns;

        System.out.println("Enter the number of rows:");
        rows = in.nextInt();

        System.out.println("Enter the number of seats in each row:");
        columns = in.nextInt();

        theatre = new String[rows][columns];


        boolean terminate = false;
        setSets(rows, columns);
        int totalTicketIncome = 0;
        do {
            int choice;
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    showSeats(rows, columns);
                    break;
                case 2:
                    System.out.println("Enter a row number:");
                    sR = in.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    sC = in.nextInt();
                    buyTicket();
                    System.out.print("Ticket Price: ");
                    int tick = ticketPrice(rows, columns);
                    System.out.println("$" + tick);
                    totalTicketIncome += tick;
                    break;
                case 3:
                    stats(rows, columns, totalTicketIncome);
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

    public static void buyTicket() {
        while (sR < 0 || sR > theatre.length
                || sC < 0 || sC > theatre[0].length || theatre[sR-1][sC-1].equals("B")) {
            if ((sR-1) < theatre.length && (sC-1) < theatre[0].length &&
                    (sR-1) >= 0 && (sC-1) >= 0) {
                System.out.println("That ticket has already been purchased!\n");
            } else {
                System.out.println("Wrong input!\n");
            }
            System.out.println("Enter a row number: ");
            sR = in.nextInt();
            System.out.println("Enter a seat number in that row:");
            sC = in.nextInt();
        }
        for (int i = 0; i < theatre.length; i++) {
            for (int j = 0; j < theatre[i].length; j++) {
                if (i+1 == sR && j+1 == sC) {
                    if (!theatre[i][j].equals("B"))  theatre[i][j] = "B";
                }
            }
        }
    }

    public static int ticketPrice(int rows, int columns) {
        int seats = rows * columns;
        int ticket;
        if (seats < 60) {
            ticket = 10;
        } else {
           if (sR <= rows / 2) {
                ticket = 10;
            } else {
                ticket = 8;
            }
        }
        return ticket;
    }

    public static int totalIncome (int r, int c) {
        int seats = r * c;
        int income;
        if (seats < 60) {
            income = seats * 10;
        } else {
            int front;
            int back;
            if(r % 2 == 0) {
                front = ((r / 2) * c) * 10;
                back = ((r / 2) * c) * 8;
                income = front + back;
            } else {
                front = ((r / 2) * c) * 10;
                back = (((r/2) + 1) * c) * 8;
                income = front + back;
            }
        }
        return income;
    }

    public static void stats(int r, int c, int ticketIncome) {
        int numTickets = 0;
        for (String[] strings : theatre) {
            for (String string : strings) {
                if (!string.equals("B")) continue;

                numTickets++;
            }
        }

        float perTickets = ((float) numTickets / (r * c)) * 100;

        int totIncome = totalIncome(r, c);

        System.out.printf("Number of purchased tickets: %d%n", numTickets);
        System.out.printf("Percentage: %.2f%s%n", perTickets, "%");
        System.out.printf("Current income: $%d%n", ticketIncome);
        System.out.printf("Total income: $%d%n%n", totIncome);
    }
}
