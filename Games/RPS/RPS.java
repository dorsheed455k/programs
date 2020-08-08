import java.util.Scanner;

public class RPS {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double generator;
        int count = 0;
        int userWins = 0;
        int personPlay;
        double computerPlay;
        String win = "Y";
        String u;
        String c;
        String blue = "\033[0;94m";
        String red = "\033[0;91m";
        String green = "\033[0;92m";
        String reset = "\u001B[0m";
        char c1 = 9786;
        char c2 = 9785;

        System.out.println("\n--------------------------- ROCK-PAPER-SCISSORS PROGRAM ---------------------------");
        System.out.print("\nWelcome to Rock-Paper-Scissors!\nEnter 'y' to play: ");
        while (playAgain()) {
            do {
                count++;
                generator = (Math.random()*3) + 1;
                computerPlay = generator;
                System.out.print("Enter your choice (1 = Rock,  2 = Paper, 3 = Scissors): ");
                personPlay = sc.nextInt();
                u = USER(personPlay);

                if (personPlay <= 3 && personPlay >= 1) {
                    System.out.print("You choose: " + u);
                    c = CPU(computerPlay);
                    System.out.print("\nComputer choose: " + c);
                    if (u.equals(c)) {
                        System.out.printf("\n%sIts a tie game%s!\n", blue, reset);
                    } else if (!u.equals(c)) {
                        String rWin = Winner(c, u);
                        if (win.equals(rWin)) {
                            System.out.printf("\n%sYou win! %c(%s BEATS %s)%s\n", green, c1, u, c, reset);
                            userWins++;
                        } else if (!win.equals(rWin)) {
                            System.out.printf("\n%sYou lost %c (%s BEATS %s)%s\n", red, c2, c, u, reset);
                        }
                    }
                } else if (personPlay >= 3 || personPlay <= 1) {
                    System.out.print("\nInput can not be greater then 3; Try again.\n");
                }
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException ex) { }

                System.out.print("\nTo play again, enter 'y', otherwise to exit enter any other key: ");

            } while (playAgain());

           System.out.printf("You won: %d out of %d games.\nThanks for playing. Goodbye!", userWins, count);
        }
    }

    public static String CPU(double computerPlay) {
        int computerPlay1 = (int) computerPlay ;
        String response = " ";
        switch (computerPlay1) {
            case 1:
                response = "ROCK";
                break;
            case 2:
                response = "PAPER";
                break;
            case 3:
                response = "SCISSORS";
                break;
        }
        return response;
    }

    public static String USER(int personPlay) {
        String play = " ";

        switch(personPlay) {
            case 1:
                play = "ROCK";
                break;
            case 2:
                play = "PAPER";
                break;
            case 3:
                play = "SCISSORS";
                break;
        }
        return play;
    }

    public static String Winner(String c, String u) {
        if ((u.equals("ROCK") && c.equals("SCISSORS")) || u.equals("SCISSORS") && c.equals("PAPER") || (u.equals("PAPER") &&  c.equals("ROCK"))) {
            return "Y";

        } else if ((u.equals("SCISSORS") && c.equals("ROCK")) || (u.equals("PAPER") && c.equals("SCISSORS")) || (u.equals("ROCK") && c.equals("PAPER"))) {
            return "N";
        }
        return "N";

    }

      static boolean playAgain() {
        String playAgain = sc.next();
        if (playAgain.equalsIgnoreCase("Y")) {
            return true;
        } else if (!playAgain.equalsIgnoreCase("Y")) {
            return false;
        }
        return false;
    }
}
