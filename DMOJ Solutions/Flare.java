import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Flare {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int v = Integer.parseInt(in.readLine());
        System.out.printf("%.6f", timeElapsed(v));
    }


    public static float timeElapsed(int v) {

        float t1 = v;
        float t2 = (float) (0.5 * (-9.8));
        float time = -t1 / t2;

        return time;
    }
}
