import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Funghi {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[8];

        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        int mak = 0;

        for (int i = 0; i < 8; i++) {
            int p1 = i;
            int p2, p3, p4;
            if(i + 1 > 7) {
                p2 = (i+1) - 8;
            }  else {
                p2 = i+1;
            }
            if(i + 2 > 7) {
                p3 = (i+2) - 8;
            } else {
                p3 = i+2;
            }
            if(i + 3 > 7) {
                p4 = (i+3) - 8;
            } else {
                p4 = i+3;
            }
            int sum = arr[p1] + arr[p2] + arr[p3] + arr[p4];
            mak = Math.max(mak, sum);

        }

        System.out.println(mak);
    }
}
