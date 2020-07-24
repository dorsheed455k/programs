import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleEncryption {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String key = in.readLine();

        String str = in.readLine();

        System.out.println(encrypt(key, str));

    }

    public static String encrypt(String key, String str) {

        StringBuilder sb = new StringBuilder();

        int l;
        int i = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) >= 'A' && str.charAt(j) <= 'Z') {
                    l = str.charAt(j) + key.charAt(i) - 'A';
                    if(l > 'Z') {
                        l = 'A' + (l - 'Z')-1;
                    }
                    sb.append((char) l);
                    i++;
                    if(i == key.length()) {
                        i = 0;
                    }
                }
            }

        return sb.toString();
    }
}
