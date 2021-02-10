import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Emacs {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n, m;

        String[] line = in.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        String[] arr = new String[1000];

        for (int i = 0; i < n; i++) {
           arr[i] = in.readLine();
        }

        int sol = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if((i == 0 || arr[i-1].charAt(j) == '.') &&
                        (j == 0 || arr[i].charAt(j-1) == '.')
                        && arr[i].charAt(j) == '*') {
                    sol++;
                }
            }
        }
        System.out.println(sol);
    }
}
