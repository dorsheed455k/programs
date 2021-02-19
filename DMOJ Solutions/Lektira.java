import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lektira {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s = in.readLine();
        int n = s.length();
        String ret = "~";
        String t = "";
        for (int i = 1; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                String a = s.substring(0, i);
                String b = s.substring(i, j);
                String c = s.substring(j);

                t = rev(a) + rev(b) + rev(c);

                if (t.compareTo(ret) < 0) {
                    ret = t;
                }
                t = "";
            }
        }
        System.out.println(ret);
    }


    public static String rev(String s) {
        StringBuilder sb = new StringBuilder(s);

        sb.reverse();

        return sb.toString();
    }
}
