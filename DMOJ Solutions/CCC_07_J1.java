import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer[] arr = new Integer[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(in.readLine());

        }

        Arrays.sort(arr);
        System.out.println(arr[1]);
    }
}
