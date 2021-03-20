import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cheese_kun {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int w = Integer.parseInt(in.readLine());
        int c = Integer.parseInt(in.readLine());

        if (w == 3 && c >= 95) {
            System.out.println("C.C. is absolutely satisfied  with her pizza.");
        } else if(w == 1 && c <= 50) {
            System.out.println("C.C. is fairly satisfied  with her pizza.");
        } else {
            System.out.println("C.C. is very satisfied with her pizza.");
        }
    }
}
