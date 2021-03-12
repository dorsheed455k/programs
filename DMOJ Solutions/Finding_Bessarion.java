import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Finding_Bessarion {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        String[] stations = new String[n];

        for (int i = 0; i < n; i++) {
            stations[i] = in.readLine();
        }

        for (int i = 1; i < n-1; i++) {
            if (stations[i].equals("Bessarion")) {
                if (stations[i-1].equals("Leslie") && stations[i+1].equals("Bayview") ||
                    stations[i+1].equals("Leslie") && stations[i-1].equals("Bayview")) {
                    System.out.println("Y");
                    return;
                }
            }
        }
        System.out.println("N");
    }
}
