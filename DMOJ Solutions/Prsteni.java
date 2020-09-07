import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prsteni {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        String[] line = in.readLine().split(" ");

        int firstCir = Integer.parseInt(line[0]);
        for (int i = 1; i < n; i++) {
            int  radii = Integer.parseInt(line[i]);
            System.out.println(num_Rotate(firstCir, radii));
        }
    }

    public static String num_Rotate(int org, int cirle) {
        int num = org;
        int dem = cirle;
        int gcd = _gcd(num, dem);
        if(gcd == 1) {
            return num + "/" + dem;
        } else {
            int newNum = num/gcd;
            int newDem = dem/gcd;
            return num_Rotate(newNum, newDem);
        }
    }

    public static int _gcd(int n1, int n2) {
        int gcd = 1;
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}
