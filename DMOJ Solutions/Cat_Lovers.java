import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int c = 0, d = 0;
        while (n-- > 0) {
            String str = in.readLine();
            if(str.equals("cats")) c++;
            if(str.equals("dogs")) d++;
        }


        System.out.println(Preference(c, d));
    }

    public static String Preference(int c, int d) {
        if(c > d) {
            return "cats";
        } else if(c < d) {
            return "dogs";
        } else {
            return "equal";
        }
    }
}
