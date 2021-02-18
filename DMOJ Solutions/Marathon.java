import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Marathon {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n;
        char[][] arr = new char[30][31];
        int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
        int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
        int i = 0;
        n = Integer.parseInt(in.readLine());
        int N = n;
        boolean winner = false;
        String lett = "";
        while (N-- > 0) {
            arr[i] = in.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 8; k++) {
                    if (arr[i][j] == '.') continue;
                    int r2 = i + dr[k], c2 = j + dc[k];
                    int r3 = r2 + dr[k], c3 = c2 + dc[k];
                    if (r3 < 0 || r3 >= n) continue;
                    if (c3 < 0 || c3 >= n) continue;
                    if (arr[i][j] == arr[r2][c2] && arr[r2][c2] == arr[r3][c3]) {
                        lett = String.valueOf(arr[i][j]);
                    }
                }
            }
            i++;
        }
        if(lett.length() > 0) {
            System.out.println(lett);
        } else {
            System.out.println("ongoing");
        }
    }
}
