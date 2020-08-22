import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AssigningPartner {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        String[] a = in.readLine().split(" ");
        String[] b = in.readLine().split(" ");

        String[] partners = new String[n];

        for (int i = 0; i < n; i++) {
            partners[i] = a[i] + " ";
            partners[i] +=  b[i];
        }

        if(are_Partners(partners, n)) {
            System.out.println("good");
        } else {
            System.out.println("bad");
        }
    }

    public static boolean are_Partners(String[] p, int n) {

        for (int i = 0; i < n; i++) {
            String[] p1 = p[i].split(" ");
            for (int j = i+1; j < n; j++) {
                String[] p2 = p[j].split(" ");
                if((p1[0].equals(p2[0]) && !p1[1].equals(p2[1])) ||
                   (p1[1].equals(p2[1]) && !p1[0].equals(p2[0])) ||
                   (p1[0].equals(p2[1]) && !p1[1].equals(p2[0]))) {
                    return false;
                }
                if(p2[0].equals(p2[1])) {
                    return false;
                }
            }
            if(p1[0].equals(p1[1])) {
                return false;
            }
        }
        return true;
    }
}
