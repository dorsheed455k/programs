import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yesnt {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s = in.readLine();

        int start = (s.charAt(0) == 'n'? 2 : 3);
        int ans = (int) (s.charAt(0) == 'n'? -1 * Math.pow(-1, ((s.length()-1) - start)/2): 1 * Math.pow(-1, ((s.length()-1) - start)/2));
        System.out.println(ans == -1? "no" : "yes");
    }
}
