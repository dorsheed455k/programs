import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int maxCold = Integer.MAX_VALUE;
        String city = " ";

        String c;
        int temp;
        String[] str = in.readLine().split(" ");

        c = str[0]; temp = Integer.parseInt(str[1]);

        do {
            if(temp < maxCold) {
                maxCold = temp;
                city = c;
            }
            str = in.readLine().split(" ");
            c = str[0]; temp = Integer.parseInt(str[1]);
        } while (!c.equals("Waterloo"));

        System.out.println(city);
    }
}
