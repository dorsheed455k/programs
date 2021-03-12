import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class New_Key {

    static String decrypt = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        char[] code = in.readLine().toCharArray();

        for (char c : code) {
            if (c >= '0' && c <= '9') {
                System.out.print(check(c));
            } else if (c >= 'A' && c <= 'J') {
                System.out.print(check(c));
            } else if (c >= 'K' && c <= 'P') {
                System.out.println(check(c));
            }
        }
    }

    public static char check(char c) {
        char index = 0;
        for (int i = 0; i < decrypt.length(); i++) {
            if (c == decrypt.charAt(i)) {
                index = decrypt.charAt(i+9);
                break;
            }
        }
        return index;
    }
}
