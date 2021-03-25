import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Utrka {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        Map<String, Integer> mp = new HashMap<>();
        ArrayList<String> cont = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = in.readLine();
            cont.add(s);
            if (mp.containsKey(s)) {
                mp.put(s, mp.get(s) + 1);
            } else {
                mp.put(s, 1);
            }
        }

        for (int i = 0; i < n-1; i++) {
            String s = in.readLine();
            mp.put(s, mp.get(s)-1);
        }
        for(String i : cont) {
            if (mp.get(i) == 1) {
                System.out.println(i);
                break;
            }
        }
    }
}
