import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class Cutting_Logs {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int curr = 0;
        Vector<Integer> ll = new Vector<>();

        String s = in.readLine();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'X') {
                if (curr > 0) {
                    ll.add(curr);
                }
                curr = 0;
            } else {
                curr++;
            }
        }
        if(curr > 0) {
            ll.add(curr);
        }
        System.out.println(ll.size());
        for(Integer x : ll) {
            while (x-- > 0) {
                System.out.print("O");
            }
            System.out.println();
        }
    }
}
