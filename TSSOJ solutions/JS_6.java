import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jonathan_Sumabat_6 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String f = in.readLine();
        String words = in.readLine();

        for (int j = 0; j < 26; j++) {
            if (words.contains(f)) {
                System.out.println("YOUR SOUL IS MINE");
                return;
            }
            f = shift(f);
        }
        System.out.println("PRANKED");
    }

    public static String shift(String s) {
       String st1 = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int ascii = (int) c + 1;
            if (ascii == 123) {
                ascii = 97;
            }
            st1 += (char) ascii;
        }
        return st1;
    }
}
