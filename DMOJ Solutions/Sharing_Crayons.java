/*
   DMOPC '17 Contest 1 P2 - Sharing Crayons 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Sharing_Crayons {
   static HashMap<Integer,Integer> crayons = new HashMap<Integer,Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String [] ln = in.readLine().split(" ");

        int n = Integer.parseInt(ln[0]);
        int m = Integer.parseInt(ln[1]);
        crayons.put(0, 1);

        ln = in.readLine().split(" ");
        int count = 0;
        long ans = 0;
        for(int i = 0 ; i < n ; i ++) {
            count =(count + Integer.parseInt(ln[i]))%m;
            if(crayons.get(count)==null) {
                crayons.put(count, 1);
            } else {
                ans = ans + Long.parseLong(String.valueOf(crayons.get(count)));
                crayons.put(count, crayons.get(count)+1);
            }
        }
        System.out.println(ans);
    }
}
