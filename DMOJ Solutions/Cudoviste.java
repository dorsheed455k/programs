import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cudoviste {

    static int r, c;
    static char[][] arr = new char[50][50];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        String[] line = in.readLine().split(" ");

        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);

        for (int i = 0; i < r; i++) {
            arr[i] = in.readLine().toCharArray();
        }

        map();
    }

    public static void map() {
        int[] crush = new int[5];
        crush[0] = 0;

        for (int i = 0; i + 1 < r; i++) {
            for (int j = 0; j + 1 < c; j++) {
             int s = 0;
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        s +=  arr[i+k][j+l] == '#'? 100 :  (arr[i + k][j + l] == 'X' ? 1 : 0);
                    }
                }
                if (s < 100) {
                    crush[s]++;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(crush[i]);
        }
    }
}
