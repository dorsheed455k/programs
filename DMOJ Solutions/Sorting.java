import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        sort(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }

    }

    public static int[] sort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int temp;
            for (int j = i+1;j < n; j++) {
                if(arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
