import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Professor {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int x = 0, y = 0;
        int MAX = 100100;
        int[] a = new int[MAX];
        int[] b = new int[MAX];

        for (int i = 0; i < n; i++) {
            String[] ln = in.readLine().split(" ");
            a[i] = Integer.parseInt(ln[0]);
            b[i] = Integer.parseInt(ln[1]);
        }

        for (int grade = 1; grade <= 5; grade++) {
            int len = 0;
            for (int k = 0; k < n; k++) {
                if(a[k] == grade || b[k] == grade)  {
                    len++;
                } else {
                    len = 0;
                }
                if(len > x) {
                    x = len;
                    y = grade;
                }
            }
        }

        System.out.println(x + " " + y);
    }
}
