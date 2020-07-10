import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s = in.readLine();

        System.out.println(punctuate(s));

    }

    public static String punctuate(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char lett = s.charAt(i);
            sb.append(lett);
                if (i < s.length()-2 && Character.isUpperCase(s.charAt(i+2))) {
                    sb.append(".");
                }
            }
        sb.append(".");


        return sb.toString();
    }
}
