import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Vector;

public class Sawmill {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        Vector<Integer> saw = new Vector<>();
        Vector<Integer> log = new Vector<>();

        String[] l1 = in.readLine().split(" ");
        String[] l2 = in.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            saw.add(Integer.parseInt(l1[i]));
            log.add(Integer.parseInt(l2[i]));
        }

        Collections.sort(saw);
        Collections.sort(log);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += saw.get(i) * log.elementAt(n-i-1);
        }

        System.out.println(ans);
    }
}
