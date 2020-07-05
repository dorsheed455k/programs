import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());


        for (int i = 0; i < n; i++) {
            String cc = in.readLine();
            StringBuilder out = new StringBuilder();
            String curr = String.valueOf(cc.charAt(0));
            int count = 0;

            for (int j = 0; j < cc.length(); j++) {
                String ca = String.valueOf(cc.charAt(j));
                if(ca.equals(curr)) {
                    count++;
                    continue;
                }
                out.append(count);
                out.append(" ");
                out.append(curr);
                out.append(" ");
                count = 1;
                curr = ca;
            }
            out.append(count);
            out.append(" ");
            out.append(curr);
            System.out.println(out.toString());
        }
    }
}
