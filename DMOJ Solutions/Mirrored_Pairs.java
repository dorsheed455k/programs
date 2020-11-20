import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MirroredPairs {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String txt = in.readLine();

        System.out.println("Ready");
        do {
            if((txt.charAt(0) == 'q' && txt.charAt(1) == 'p') ||
               (txt.charAt(1) == 'q' && txt.charAt(0) == 'p') ||
               (txt.charAt(0) == 'd' && txt.charAt(1) == 'b') ||
               (txt.charAt(1) == 'd' && txt.charAt(0) == 'b')) {
                System.out.println("Mirrored pair");
            } else {
                System.out.println("Ordinary pair");
            }
            txt = in.readLine();
        } while (!txt.equals("  "));
    }
 }
