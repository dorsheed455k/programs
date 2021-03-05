import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class Brodovi {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        Vector<Integer> ships = new Vector<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(in.readLine());
            x--; if (i == 0) continue;

            for (int j = 0; j < ships.size(); j++) {
                if (x % ships.get(j) == 0) {
                    x = -1;
                    break;
                }
            }
            if (x != -1) ships.add(x);
        }
        System.out.println(ships.size());
    }
}
