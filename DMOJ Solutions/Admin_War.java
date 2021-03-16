import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Admin_War {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int[] a = new int[n];
        int[] b = new int[n];

        String[] l1 = in.readLine().split(" ");
        String[] l2 = in.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(l1[i]);
            b[i] = Integer.parseInt(l2[i]);
        }
        int[] arr = {0, 0};
        for (int i = 0; i < n; i++) {
            if (a[i] > b[i]) {
                arr[0]++;
            } else if(a[i] < b[i]) {
                arr[1]++;
            }
        }
        System.out.println(arr[0] + " " + arr[1]);
        if (arr[0] > arr[1]) {
            System.out.println("Xyene");
        } else if(arr[0] < arr[1]) {
            System.out.println("FatalEagle");
        } else {
            System.out.println("Tie");
        }
    }
}
