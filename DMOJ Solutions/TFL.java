import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int k = Integer.parseInt(in.readLine());

            k += 1;
            long nxt;
            while (true) {
                nxt = k;
                nxt = (long) Math.pow(nxt, 3);
                if(lastCube(nxt)) {
                    System.out.println(k);
                    break;
                } else {
                    k++;
                }
            }
        }
    }

    public static boolean lastCube(long nxt) {
        String n = String.valueOf(nxt);
        if(n.endsWith("888")) {
            return true;
        }
        return false;
    }
}
