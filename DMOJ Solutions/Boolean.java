import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boolTest {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String test[] = in.readLine().split(" ");
        if (test.length == 0) {
            System.out.println(" ");
        } else {
            occurrence(test);
        }
    }

    public static void occurrence(String[] occur) {
        boolean ans;
        if(occur[occur.length-1].equals("True"))
            ans = true;
        else
            ans = false;

        if (occur.length%2 == 0)
            ans = !ans;
        if(ans) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
