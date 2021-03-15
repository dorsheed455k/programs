import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Physics_Dual {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        double a = 0;
        int b = Integer.parseInt(in.readLine());

        for (int i = 0; i < b; i++) {
            String[] ln = in.readLine().split(" ");
            int c = Integer.parseInt(ln[0]);
            double d = Double.parseDouble(ln[1]);
            double e = Double.parseDouble(ln[2]);
            a += (e * (c * Math.sin(d*Math.PI / 180.0d)));
        }
        double f = Math.sqrt(2 * 9.8 * a);
        System.out.println((int) Math.round(f));
    }
}
