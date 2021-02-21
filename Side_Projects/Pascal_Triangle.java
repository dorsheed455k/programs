/*
 Pascal Triangle - Prompts the user to enter in a number of 'n' rows in a pyrimad
 afterwards outputting a pascal triangle using the pascal algorithm
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int i, j;
        String prompt = "Type in the number of rows in the pyrimad: ";
        for(i = 0; i < prompt.length(); i++){
            System.out.printf("%c", prompt.charAt(i));
           try {
              Thread.sleep(100);
           }catch(InterruptedException ex){
              Thread.currentThread().interrupt();
    }
}
        int n = Integer.parseInt(in.readLine());


        int max = 0;
        for(i = 0; i <= n; i++) {
            for(j = 0; j <= n-i; j++){
                System.out.print("  ");
            }
            for(j = 0; j <= i; j++){
                if(ncr(i, j) > max) max = ncr(i, j);
                if(ncr(i, j) > 9) {
                    System.out.print("  " + ncr(i, j));
                } else {
                    System.out.print("   " + ncr(i, j));
                }
            }
            System.out.println();
        }

        System.out.println("\nMax # in tree: " + max);
    }

    static int ncr(int n,int r) {
        return pascalTree(n) / ( pascalTree(n-r) * pascalTree(r));
    }

    public static int pascalTree(int n) {
        int f;
        for (f = 1; n > 1; n--) {
            f *= n;
        }
        return f;
    }
}
