import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Kajak {

    static char[][] arr = new char[100][101];

    public static void main(String[] args) throws IOException {

         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> place = new HashMap<>();
        int r, c;

        String[] ln = in.readLine().split(" ");

        r = Integer.parseInt(ln[0]);
        c = Integer.parseInt(ln[1]);

        for (int i = 0; i < r; i++) {
            arr[i] = in.readLine().toCharArray();
        }

        int t = 1;
        for (int i = c - 2; i >= 1; i--) {
            int x = 0;
            for (int j = 0; j < r; j++) {
                if (isDigit(arr[j][i]) && !isDigit(arr[j][i+1])) {
                    place.put(String.valueOf(arr[j][i]), t);
                    x = 1;
                }
            }
            t += x;
        }
        
        for(Map.Entry<String, Integer> me : place.entrySet()) {
            System.out.println(me.getValue());
        }
    }

    public static boolean isDigit(char c) {
        return c >= 48 && c <= 57;
    }
}
