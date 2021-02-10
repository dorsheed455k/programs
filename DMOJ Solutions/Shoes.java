import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shoes {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] c = in.readLine().split(" ");

        if(!c[0].equals(c[1])) {
            System.out.println(1 + " " + 2 + "\n" +
                    3 + " " + 4);
        } else if(!c[0].equals(c[2])) {
            System.out.println(1 + " " + 3 + "\n" +
                    2 + " " + 4);
        } else if(!c[0].equals(c[3])) {
            System.out.println(1 + " " + 4 + "\n" +
                    2 + " " + 3);
        }
    }
}
