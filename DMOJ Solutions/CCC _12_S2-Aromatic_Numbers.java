import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

   static String[][] romanBase = {
            {"I", "1"}, {"V", "5"}, {"X", "10"}, {"L", "50"},
            {"C", "100"}, {"D", "500"}, {"M", "1000"}
    };

    public static void main(String[] arg) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        String[] str = in.readLine().split("(?<=\\G..)");
        int total = 0;
        int oldr = 0, olds = 0;

        for (int i = 0; i < str.length; i++) {
            int a = Integer.parseInt(String.valueOf(str[i].charAt(0)));
            int r = roman_to_base(str[i].charAt(1));
            int s = (a * r);

            total += s;
            if (i > 0) {
                if (r > oldr) {
                    total -= (olds * 2);
                }
            }
            olds = s;
            oldr = r;
        }

        System.out.println(total);
    }

    public static int roman_to_base(char ch) {
        String str = " ";
        for (int j = 0; j < romanBase.length; j++) {
            if(ch == romanBase[j][0].charAt(0)) {
               str = String.valueOf(romanBase[j][1]);
            }
        }
        return Integer.parseInt(str);
    }
}
