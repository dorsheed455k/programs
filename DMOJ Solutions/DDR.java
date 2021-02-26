import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DDR {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] ln = in.readLine().split("");

        if(ln[0].equals("U") && ln[2].equals("D") ||
           ln[0].equals("D") && ln[2].equals("U")) {
            if(!ln[1].equals(ln[0]) && !ln[1].equals(ln[2])) {
                System.out.println("Candle");
                System.exit(0);
            }
        } else if(ln[0].equals("L") && ln[2].equals("R") ||
                ln[0].equals("R") && ln[2].equals("L")) {
            if(!ln[1].equals(ln[0]) && !ln[1].equals(ln[2])) {
                System.out.println("Crossover");
                System.exit(0);
            }
        }

        System.out.println("Neither");
    }
}
