import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Core_Drill {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int r = Integer.parseInt(in.readLine());
        int h = Integer.parseInt(in.readLine());

        volume(r, h);
    }

    public static void volume(int r, int h) {
        float v = (float) (Math.PI * Math.pow(r, 2) * h);
        v = v/3;
        System.out.printf("%.2f", v);
    }
}
