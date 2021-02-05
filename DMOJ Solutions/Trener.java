import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Trener {

    public static void main(String[] arg) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int[] arr = new int[26];

        for (int i = 0; i < n; i++) {
            char lett = in.readLine().charAt(0);
            arr[lett-'a']++;
        }

        System.out.println(forfeit(arr));
    }

   public static String forfeit(int[] fl) {

        String team = "";
        boolean ok = false;
        for (int i = 0; i < 26; i++) {
            if(fl[i] >= 5) {
               team +=  (char) (i + 'a');
               ok = true;
            }
        }

       return ok? team : "PREDAJA";
    }
}
