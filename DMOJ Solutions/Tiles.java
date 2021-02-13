import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tiles {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int w, l, ts;

        String[] line = in.readLine().split(" ");

        w = Integer.parseInt(line[0]);
        l = Integer.parseInt(line[1]);

        ts = Integer.parseInt(in.readLine());

        int rA = (int) Math.floor(w / ts);
        int tA = (int) Math.floor(l / ts);

        int maxTiles = rA * tA;

        System.out.println(maxTiles);

    }
}
