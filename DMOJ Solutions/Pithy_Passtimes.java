import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] ags) throws IOException {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int count = 0;
        for (int i = 0; i < n; i++) {
            String act = in.next();
            if(act.length() <= 10) {
                count++;
            }
        }

        System.out.println(count);
    }
}
