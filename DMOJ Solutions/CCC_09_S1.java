import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(in.readLine());
        int b = Integer.parseInt(in.readLine());
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (Math.sqrt(i) == (int)Math.sqrt(i) && Math.cbrt(i) == (int)Math.cbrt(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
