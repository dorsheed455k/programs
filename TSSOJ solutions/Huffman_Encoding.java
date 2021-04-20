import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Huffman_Encoding {

    static char[] ch;
    static String[] seq;
    static String code;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        ch = new char[n];
        seq = new String[n];

        for (int i = 0; i < n; i++) {
            String[] line = in.readLine().split(" ");
            ch[i] = line[0].charAt(0);
            seq[i] = line[1];
        }
        code = in.readLine();

        String message = Encode();
        System.out.println(message);
    }

    public static String Encode() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < code.length()) {
            for (int j = 0; j < seq.length; j++) {
               if(code.charAt(i) == ch[j]) {
                   sb.append(seq[j]);
                   break;
               }
            }
            i++;
        }
        return sb.toString();
    }
}
