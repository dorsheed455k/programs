import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dosadan {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];

        String[] ln = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(ln[i], 16);
            if(arr[i] < 0x20) {
                System.out.print(".");
            } else {
                System.out.print("-");
            }
        }
    }
}
