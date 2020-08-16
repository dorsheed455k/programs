import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class WPMGame {

    private static final String[] words = {
            "family", "bury", "museum", "paint", "coach", "asset", "industry", "nail",
            "radio", "fail", "wing", "position", "recovery", "follow", "convert", "introduce",
            "fish", "current", "tissue", "van", "defeat", "swim", "season", "spill", "do", "wander",
            "vertical", "elephant", "envelope", "can", "cast", "medicine", "channel", "magnitude",
            "embarrassment", "fat", "dorm", "responsible", "wagon", "argue", "shake", "paint", "spring",
            "start", "consist", "kick", "clearance", "insight", "active", "marine", "captain", "talented"
    };

    private static String asciRed = "\u001b[31;1m";
    private static String asciGreen = "\u001b[32m";
    private static String asciReset = "\u001b[0m";
    private static String asciBlueBack = "\u001b[44m";
    private static int counter = 0;

    public WPMGame() throws InterruptedException {
        Scanner in = new Scanner(System.in);
        
        titleBanner();
        Thread.sleep(2000);

        System.out.print("Objective: This program allows you to test the number of words\n" +
                "you can type in a minute given a simple test case that you are to copy. Afterwards you words typed\n" +
                "per minute will be calculated and displayed shortly after you done, aswell as your overall accuracy.\nTo begin,type in 'y': ");

        Random rand = new Random();
        String begin = in.nextLine();

        while (begin.equalsIgnoreCase("y")) {
            StringBuilder sb = new StringBuilder(140);
            StringBuilder user = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                String str = words[rand.nextInt(52)];
                if(i == 0) {
                    char firstLett = Character.toUpperCase(str.charAt(0));
                    sb.append(firstLett);
                    sb.append(str.substring(1,str.length()));
                    sb.append(" ");
                } else {
                    sb.append(str);
                    sb.append(" ");
                }
            }
            System.out.println();

            countDown();

            System.out.println("Test Sample: "+ "\u001b[1m" + asciBlueBack + sb.toString() + asciReset+"\n");
            remove_WhiteSpace(sb);
            System.out.print("Type here: ");

            String input;
            double start;
            do {
                int l = 0;
                start = LocalTime.now().toNanoOfDay();
                for (int i = 0; i < 10; i++) {
                    input = in.next();
                    user.append(input);
                    for (int j = 0; j < input.length(); j++) {
                        compare(sb, l, input, j);
                        l++;
                    }
                    System.out.print(" ");
                }
            } while (user.length() >= sb.length());
            double end = LocalTime.now().toNanoOfDay();

            int acc = ((counter+1)*100 + (sb.length() >> 1)) / sb.length();

            System.out.printf("\nAccuracy: %d%%\n", acc);

            int wpm = Timer(sb.length(), end, start);

            System.out.println("Words Per Minute: " + wpm);

            System.out.print("Try again? (Press 'y' if so): ");
            begin = in.next();
            counter = 0;
            sb.setLength(0);
        }

    }


    public static void titleBanner() {
        String wpm = "____                        __ ___   __________        /__/\\            /___/ |\n" +
                     "\\ \\  \\        __ __        /  /  /  /________ / \\     |    \\\\         /     | |\n" +
                     " \\ \\  \\      / /   \\      /  /  /   |  ||    \\ \\ |    |     \\\\       /      | |\n" +
                     "  \\ \\  \\    / /     \\    /  /  /    |  ||     | ||    |      \\\\     /       | |\n" +
                     "   \\ \\  \\  / /       \\  /  /  /     |  ||     | ||    |   |\\  \\\\   /   /|   | |\n" +
                     "    \\ \\  \\/ /   / \\   \\/  /  /      |  ||_____/ //    |   | \\  \\\\ /   / |   | |\n" +
                     "     \\ \\  \\/   / \\ \\   \\ /  /       |  ________//     |   | |\\  \\/   /  |   | |     __           __                 ___   __    _\n" +
                     "      \\ \\     /   \\ \\      /        |  ||             |   | | \\     /   |   | |    |    /\\  |   |    |  | |     /\\   |   |  |  |_|\n" +
                     "       \\_\\___/     \\_\\____/         |__|/             |___|/   \\___/    |___|/     |__ /--\\ |__ |__  |__| |__  /--\\  |   |__|  |\\\n";

        System.out.println("======================================================================================");
        System.out.println(asciGreen + wpm + asciReset);
        System.out.println("======================================================================================");
    }

    public static void countDown() throws InterruptedException {
        System.out.println("\n");
        for (int i = 3; i >= 0; i--) {
            System.out.printf("Begin typing in %d\r", i);
            Thread.sleep(1000);
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

    public static void remove_WhiteSpace(StringBuilder sb) {
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == ' ') {
                sb.replace(i, i + 1, "");
            }
        }
    }

    public static void compare(StringBuilder sb, int l, String input, int j) {
        if (input.charAt(j) != sb.charAt(l)) {
            System.out.print(asciRed + sb.charAt(l) + asciReset);
        } else {
            System.out.print(asciGreen + sb.charAt(l) + asciReset);
            counter++;
        }
    }


    public static int Timer(int typedWords, double end, double start) {
        double elapsedTime = end - start;
        double seconds = elapsedTime / 1000000000.0;
        int numChars = typedWords;
        int wpm = (int)((((double)numChars / 5) / seconds) * 60);

        return wpm;
    }
}
