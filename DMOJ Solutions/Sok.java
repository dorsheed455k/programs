import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sok {
    
    public static void main(String[] arg) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] bought = new int[3];
        int[] required = new int[3];

        String[] l1 = in.readLine().split(" ");
        String[] l2 = in.readLine().split(" ");
        for (int i = 0; i < 3; i++) {
            bought[i] = Integer.parseInt(l1[i]);
            required[i] = Integer.parseInt(l2[i]);
        }

        double best = 0;
        for (int i = 0; i < 3; i++) {
            double t = 1.0 * bought[i] / required[i];
            if (t > best) {
                if ( bought[0] - required[0] * t >= - 1e-9 )
                    if ( bought[1] - required[1] * t >= - 1e-9 )
                        if ( bought[2] - required[2] * t >= - 1e-9 )
                            best = t;
            }
        }

        double[] left = new double[3];
        for (int i = 0; i < 3; i++) {
            left[i] = bought[i] - required[i] * best;
        }

        for (int i = 0; i < 3; i++) {
            System.out.printf("%.4f ", left[i]);
        }
    }
}
