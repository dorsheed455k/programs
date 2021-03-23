/*
  CCC_02_J1 - 0123456789
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CCC_02_J1 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        if(n == 0) {
            System.out.println(" * * *\n*     *\n*     *\n*     *\n\n*     *\n*     *\n*     *\n * * *");
        } else if (n == 1) {
            System.out.println("\n      *\n      *\n      *\n\n      *\n      *\n      *\n");
        } else if (n == 2) {
            System.out.println(" * * *\n      *\n      *\n      *\n * * *\n*\n*\n*\n * * *");
        } else if (n == 3) {
            System.out.println(" * * *\n      *\n      *\n      *\n * * *\n      *\n      *\n      *\n * * *");
        } else if (n == 4) {
            System.out.println("\n*     *\n*     *\n*     *\n * * *\n      *\n      *\n      *\n");
        } else if (n == 5) {
            System.out.println(" * * *\n*\n*\n*\n * * *\n      *\n      *\n      *\n * * *");
        } else if (n == 6) {
            System.out.println(" * * *\n*\n*\n*\n * * *\n*     *\n*     *\n*     *\n * * *");
        } else if (n == 7) {
            System.out.println(" * * *\n      *\n      *\n      *\n\n      *\n      *\n      *\n");
        } else if (n == 8) {
            System.out.println(" * * *\n*     *\n*     *\n*     *\n * * *\n*     *\n*     *\n*     *\n * * *");
        } else if (n == 9) {
            System.out.println(" * * *\n*     *\n*     *\n*     *\n * * *\n      *\n      *\n      *\n * * *");
        }
    }
}
