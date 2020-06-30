import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int k = Integer.parseInt(in.readLine());

        int sum = n;
        int[] arr = new int[k];

        for (int i = 0; i < k ; i++) {
            arr[i] = (int) (n * Math.pow(10, (i+1)));
        }

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
    }
}
