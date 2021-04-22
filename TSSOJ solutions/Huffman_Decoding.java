import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Huffman_Decoding {

    static char[] ch;
    static String[] binary;
    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());

        ch = new char[n];
        binary = new String[n];
        for (int i = 0; i < n; i++) {
            String[] ln = in.readLine().split(" ");
            ch[i] = ln[0].charAt(0);
            binary[i] = ln[1];
        }

        String b = in.readLine();
        Decoding(b);
    }

    public static void Decoding(String b) {
        StringBuilder sb = new StringBuilder();
        while (b.length() > 0) {
            for (int i = 0; i < n; i++) {
                if (b.startsWith(binary[i])) {
                    sb.append(ch[i]);
                    b = b.substring(binary[i].length());
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
