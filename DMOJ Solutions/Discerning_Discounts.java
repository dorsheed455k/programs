import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Discerning_Discounts {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n, k;

        String[] ln = in.readLine().split(" ");

        n = Integer.parseInt(ln[0]);
        k = Integer.parseInt(ln[1]);

        int count = 0;

        for(int i = 0; i < n; i++) {
            String[] l1 = in.readLine().split(" ");
            int c = Integer.parseInt(l1[0]);
            double d = 100 - Integer.parseInt(l1[1]);
            double price = (d / 100) * c;
            if(price <= k + 0.99) {
                count++;
            }
        }
        System.out.println(count);
    }
}
