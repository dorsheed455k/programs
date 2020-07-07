import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str = in.readLine();

        int lower = 0;
        int upper = 0;

        for (int i = 0; i < str.length(); i++) {
            char lett = str.charAt(i);
            if(lett != ' ') {
                if (Character.isUpperCase(lett)) {
                    upper++;
                } else if (Character.isLowerCase(lett)) {
                    lower++;
                }
            }
        }

        for (int i = 0; i < str.length(); i++) {
            char lett = str.charAt(i);
            if(upper > lower) {
                System.out.print(Character.toUpperCase(lett));
            } else if(upper < lower) {
                System.out.print(Character.toLowerCase(lett));
            } else {
                System.out.print(lett);
            }
        }
    }
}
