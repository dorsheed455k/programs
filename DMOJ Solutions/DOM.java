import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DOM {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String line = in.readLine();

        subliminalName(line);

    }

    public static void subliminalName(String name) {

        String[] cen = name.split("[CAMBRIDGE]");

        for (int i = 0; i < cen.length; i++) {
            System.out.print(cen[i]);
        }
    }
}
