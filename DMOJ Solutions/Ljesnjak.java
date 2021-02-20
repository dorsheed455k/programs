import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ljesnjak {

    static char[] c = new char[128];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] ch = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        String line = in.readLine();
        c = line.toCharArray();

       int count = 0;
       int len = 0;
        for (int i = 0; i < line.length(); i++) {
            for (int j = 0; j < 8; j++) {
                int nxt = i + ch[j].length();
                if(nxt < line.length()) {
                    if (line.substring(i, nxt).equals(ch[j])) {
                        i = i + ch[j].length()-1;
                        count++;
                        len += ch[j].length();
                    }
                }
            }
        }

        int numLett = line.length() - len + count;

        System.out.println(numLett);
    }
}
