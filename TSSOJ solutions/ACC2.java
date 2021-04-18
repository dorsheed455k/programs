import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACC2 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int d = Integer.parseInt(in.readLine());

        if (d < 24) {
            System.out.println("December " + (24-d) + " 2019");
        } else {
            timeElapsed(d);
        }
    }

    public static void timeElapsed(int a) {
        int b = a - 24;
        int c = Math.floorDiv(b, 28) + 1;
        int d = b % 28;
        int ca = Math.floorDiv(c, 12);
        int cb = c % 12;
        String s = "";
        switch (cb) {
            case 0:
             s = "December";
             break;
            case 1:
                s = "November";
                break;
            case 2:
                s = "October";
                break;
            case 3:
                s = "September";
                break;
            case 4:
                s = "August";
                break;
            case 5:
                s = "July";
                break;
            case 6:
                s = "June";
                break;
            case 7:
                s = "May";
                break;
            case 8:
                s = "April";
                break;
            case 9:
                s = "March";
                break;
            case 10:
                s = "February";
                break;
            case 11:
                s = "January";
                break;
        }

        int y = 2019 - ca;
        int day = 28 - d;
        System.out.printf("%s %d %d", s, day, y);
    }
}
