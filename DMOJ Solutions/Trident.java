import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        int s = Integer.parseInt(in.readLine());
        int h = Integer.parseInt(in.readLine());

        for (int i = 1; i <= t; i++) {
            System.out.print("*");
            for (int j = 1; j <= s; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 1; j <= s ; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }

        for (int i = 1; i <= 2*s + 3 ; i++) {
            System.out.print("*");
        }
        System.out.println("");

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= s+1; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
    }
}
