import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int tCount = 0;
        int sCount = 0;
        for (int i = 0; i < n; i++) {
            String line = in.readLine();
            if(isEnglish(line)) {
                tCount++;
            } else {
                sCount++;
            }
        }
        if(tCount > sCount) {
            System.out.println("English");
        } else {
            System.out.println("French");
        }
    }

    public static boolean isEnglish(String txt) {
        int e = 0;
        int f = 0;
        for (int i = 0; i < txt.length(); i++) {
            if(txt.charAt(i) == 't' || txt.charAt(i) == 'T') e++;
            if(txt.charAt(i) == 's' || txt.charAt(i) == 'S') f++;
        }
        return e >= f;
    }
}
