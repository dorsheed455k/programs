import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SlotMachine {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int tickets = Integer.parseInt(in.readLine()), m1 = Integer.parseInt(in.readLine()), m2 = Integer.parseInt(in.readLine()), m3 = Integer.parseInt(in.readLine());

        int c = numTries(tickets, m1, m2, m3);

        System.out.println("Martha plays " + c + " times before going broke.");

    }

    public static int numTries(int t, int a, int b, int c) {

        int count = 0;

        while (t > 0) {
            if(t == 0) {break;}

            t--; count ++; a++;
            if(a == 35) {
                t += 30; a = 0;
            }
            if(t == 0) {break;}

            t--; count++;  b++;
            if(b == 100) {
                t += 60; b = 0;
            }
            if(t == 0) {break;}

            t--; count++;  c++;
            if(c == 10) {
                t += 9; c = 0;
            }
        }
        return count;
    }
}
