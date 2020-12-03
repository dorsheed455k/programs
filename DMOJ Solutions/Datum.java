/*
  COCI '08 Contest 4 #2 - Datum
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int d, m;
        String[] line = in.readLine().split(" ");

        d = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        String dw = dayOfWeek(d, m);

        System.out.print(dw.charAt(0));
        for (int i = 1; i < dw.length(); i++) {
            int c = dw.charAt(i) + 32;
            System.out.print((char) c);
        }
        System.out.println();
    }

    public static String dayOfWeek(int day, int month) {
        LocalDate ld = LocalDate.of(2009, Month.of(month), day);

        DayOfWeek dy = DayOfWeek.from(ld);

        return dy.name().toString();
    }
}
