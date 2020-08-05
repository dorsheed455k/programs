import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class grafitte {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String word = in.readLine();
        System.out.println(numCans(word));
    }

    public static int numCans(String str) {
        int cans = 0;
        String[] two_ch = {"DM", "DO", "DJ", "MO", "MJ", "OJ"};

        if(str.equalsIgnoreCase("DMOJ")) {
            cans = 0;
        } else if(str.contains("MOJ") || str.contains("DMO") || str.contains("DMJ") || str.contains("DOJ")) {
            cans = 1;
        } else if(is_In(two_ch, str)){
            cans = 2;
        } else {
            cans = 3;
        }
        return cans;
    }

    public static boolean is_In(String[] l, String str) {
        for (int i = 0; i < l.length; i++) {
            if(str.contains(l[i])) {
                return true;
            }
        }
        return false;
    }
}
