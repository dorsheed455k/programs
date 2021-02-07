import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kornislav {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] line = in.readLine().split(" ");

        int[] step = new int[4];

        for (int i = 0; i < 4; i++) {
            step[i] = Integer.parseInt(line[i]);
        }

        sort(step);

        System.out.println(step[0] * step[2]);
    }

    public static void sort(int[] arr) {

        for (int i = 0; i < 4; i++) {
            for (int j = i+1; j < 4; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
