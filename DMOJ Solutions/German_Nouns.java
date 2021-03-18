import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class German_Nouns {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        for (int i = 0; i < n; i++) {
            char[] ln = in.readLine().toCharArray();

            System.out.println(nouns(ln));
        }
    }

    public static int nouns(char[] arr) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 65 && arr[i] <= 90) {
                count++;
            }
        }
        return count;
    }
}
