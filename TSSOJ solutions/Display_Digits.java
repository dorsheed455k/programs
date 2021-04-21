import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Display_Digits {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String n = in.readLine();

        for (int i = 0; i < n.length(); i++) {
            System.out.println(n.charAt(i));
        }
    }
}
