import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Median_Mark {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        double[] arr = new double[n];
        double m;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }
        sort(arr);

       if(n % 2 == 1) {
           m = arr[(n+1)/2-1];
       } else {
           m = Math.round((arr[n/2-1]+arr[n/2])/2);
       }

       System.out.printf("%d\n", (int)m);
    }

    public static void sort(double[] arr) {
        int i, j;
        for (i = 0; i < arr.length; i++) {
            for (j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    double temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
