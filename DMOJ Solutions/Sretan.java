import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sretan {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(in.readLine());
        k++;

        String ret = "";
        while (k > 1) {
            if (k % 2 == 1) {
                ret = "7" + ret;
            } else {
                ret = "4" + ret;
            }
            k = k / 2;
        }

        System.out.println(ret);
    }
}
