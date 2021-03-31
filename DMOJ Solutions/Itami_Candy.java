/*
  DMOPC '15 Contest 1 P4 - Itami and Candy
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Itami_Candy {

    static int n, x;
    static boolean [] info;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));

        String [] s = in.readLine().split(" " );

        n = Integer.parseInt(s[0]);
        x = Integer.parseInt(s[1]);
        info = new boolean[n+1];

        for(int i = 0 ; i < n+1 ; i ++) {
            info[i]=true;
        }
        seive();

        int ans = 0;
        for(int i = 2 ; i < n+1; i ++) {
            if(info[i]) {
                ans += distribute(i);
            }
        }
        System.out.println(ans);
    }
    private static int distribute(int i) {
        if(i!=n) {
            return modulo(n-i) + modulo(n-i-1);
        }
        return modulo(n-i);
    }

    private static int modulo(int n) {
        return n/x+1;
    }

    private static void seive() {
        for(int i = 2; i < n+1 ; i ++) {
            if(info[i]) {
                for(int i2 = 2; i2*i<n+1; i2++) {
                    info[i*i2] = false;
                }
            }
        }
    }
}
