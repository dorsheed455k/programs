import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int b = Integer.parseInt(in.readLine());
        int n = Integer.parseInt(in.readLine());

        String[] lett = {"A", "B", "C", "D", "E"};

        while (b != 4)   {
           if (b == 1) {
               rotateRight(lett, n);
           } else if (b == 2) {
               rotateLeft(lett, n);
           } else if (b == 3) {
               swap(lett, n);
           }

            b = Integer.parseInt(in.readLine());
            n = Integer.parseInt(in.readLine());
         }

        System.out.print(lett[0]);
        for (int i = 1; i < 5; i++) {
            System.out.print(" " + lett[i]);
        }
    }

    public static String[] rotateRight(String[] arr, int n) {
        for(int i = 0; i < n; i++) {
            String temp = arr[0];
            for(int j = 0; j < arr.length-1; j++) {
                arr[j] = arr[j+1];
            }
            arr[arr.length-1] = temp;
        }
        return arr;
    }

    public static String[] rotateLeft(String[] arr, int n) {
        for(int i = 0; i < n; i++) {
            String temp = arr[arr.length-1];
            int j;
            for(j = arr.length-1; j > 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[0] = temp;
        }
        return arr;
    }

    public static String[] swap(String[] arr, int n) {
        for (int i = 0; i < n; i++) {
            String temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
        }
        return arr;
    }
}
