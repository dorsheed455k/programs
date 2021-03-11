import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Go {
  
    int MAX = 70;
    int n;
    int ma, mi;
    int totalEvo;
    int[] evo = new int[MAX];

    public Go() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = in.readLine();

            String[] ln = in.readLine().split(" ");
            int candyReq = Integer.parseInt(ln[0]);
            int candyNo = Integer.parseInt(ln[1]);

            while (candyNo >= candyReq) {
                candyNo -= candyReq;
                candyNo += 2;
                evo[i]++;
                totalEvo++;
            }
            if (evo[i] > ma) {
                ma = evo[i];
                mi = i;
            }
        }
        System.out.println(totalEvo);
        System.out.println(names[mi]);
    }

    public static void main(String[] args) throws IOException {
       new Go();
    }
}



