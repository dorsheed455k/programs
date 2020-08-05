import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        for (int i = 0; i <n ; i++) {
            String[] str = in.readLine().split(" ");
            System.out.println(censor(str));
        }
    }

    public static String censor(String[] str) {
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            if (s.length() == 4) {
                sb.append("****");
            } else {
                sb.append(s);
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}
