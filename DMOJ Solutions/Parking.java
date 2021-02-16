import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parking {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[4];

        String[] line = in.readLine().split(" ");

        arr[1] = Integer.parseInt(line[0]);
        arr[2] = Integer.parseInt(line[1]);
        arr[3] = Integer.parseInt(line[2]);

        int [] dur = new int[100];
        int t1, t2;
        for (int i = 1; i <= 3; i++) {
            String[] str = in.readLine().split(" ");
            t1 = Integer.parseInt(str[0]);
            t2 = Integer.parseInt(str[1]);

            for (int t = t1; t < t2; t++) {
                dur[t]++;
            }
        }

        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += dur[i] * arr[dur[i]];
        }

        System.out.println(sum);
    }
}
