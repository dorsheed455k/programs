import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Similies {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());

        String[] adj = new String[n];
        String[] noun = new String[m];

        for (int i = 0; i < n; i++) {
            adj[i] = in.readLine();
        }

        for (int i = 0; i < m; i++) {
            noun[i] = in.readLine();
        }

        similies(n,m,adj,noun);
    }

    public static void similies(int n, int m, String[] a, String[] no) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(a[i] + " as " + no[j]);
            }
        }
    }
}
