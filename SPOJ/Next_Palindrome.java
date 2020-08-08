import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        for (int i = 0; i < n; i++) {
           int x = Integer.parseInt(in.readLine());
           int count;
           int j = x;
           while(true) {
               j++;
                String str = String.valueOf(j);
                StringBuilder rev = new StringBuilder(str);
                rev.reverse();
                if(Integer.parseInt(rev.toString()) == Integer.parseInt(str)) {
                    count = Integer.parseInt(rev.toString());
                    System.out.println(count);
                    break;
                }
            }
        }
    }
}
