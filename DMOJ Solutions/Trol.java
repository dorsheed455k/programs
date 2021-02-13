import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Trol {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(in.readLine());

        for (int i = 0; i < q; i++) {
            String[] ln = new String[2];
            try {
               ln = in.readLine().split(" ");
            }catch(NumberFormatException ex){
                System.err.println("Invalid string in argumment");
            }
            long l = Long.parseLong(ln[0]);
            long r = Long.parseLong(ln[1]);
            long tot = r - l + 1;
            long sol = (tot / 9) * 9 * 10 / 2;
            for (int j = 0; j < tot % 9; j++) {
                long add = (l + j) % 9;
                if (add == 0) add = 9;
                sol += add;
            }
            System.out.printf("%d\n", sol);
        }
    }
}
