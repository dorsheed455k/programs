import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int j = Integer.parseInt(in.readLine()) - 1;

        int res = (j*(j-1)*(j-2))/6;

        System.out.println(res);

    }
}
