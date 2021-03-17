import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Grumpy_Dwarf {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int k = Integer.parseInt(in.readLine());

        int cnt = 0;
        while (n >= k) {
            cnt += k;
            n -= k-1;
        }

        cnt += n;
        System.out.println(cnt);
    }
}
