import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int y, m, d;

        for (int i = 0; i < n; i++) {
            String[] str = in.readLine().split(" ");
            y = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[1]);
            d = Integer.parseInt(str[2]);

            if(can_Vote(y, m, d)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }
    }

    public static boolean can_Vote(int y, int m, int d) {
        LocalDate birthDate = LocalDate.of(y, m, d);

        int  age = calculateAge(birthDate, LocalDate.of(2007, 2, 27));

        return age >= 18;
    }

    public static int calculateAge(LocalDate birthDate, LocalDate currDate) {
        return Period.between(birthDate, currDate).getYears();
    }
}
