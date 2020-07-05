import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String text = in.readLine();
        String st = in.readLine();

        int count = 0;
        for (int i = 0; i < st.length(); i++) {
            st = shift(st);
                for (int j = 0; j < text.length(); j++) {
                    if(j + st.length() <= text.length()) {
                        if(st.equals(text.substring(j,j+st.length()))) {
                            count++;
                        }
                    }
                }
             }

        if(count >= 1) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    public static String shift(String s) {
        return s.charAt(s.length()-1)+s.substring(0,s.length()-1);
    }
}
