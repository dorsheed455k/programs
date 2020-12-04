/*
  COCI '08 Contest 1 #1 - Skocimis
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        String[] line = in.readLine().split("");

        topScore(n, line);

    }

    public static void topScore(int n, String[] line) {
        String[] adrian = {"A", "B", "C"};
        String[] bruno = {"B", "A", "B", "C"};
        String[] goran = {"C", "C", "A", "A", "B", "B"};

        int a = 0, b = 0, g = 0;
        int[] score = new int[3];

        int i = 0;
        while (i < n) {
            if(a == adrian.length) a = 0;
            if(b == bruno.length) b = 0;
            if(g == goran.length) g = 0;

            if(line[i].equals(adrian[a])) {
                score[0]++;
            }
            if(line[i].equals(bruno[b])) {
                score[1]++;
            }
            if(line[i].equals(goran[g])) {
                score[2]++;
            }
            i++;
            a++; b++; g++;
        }
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < 3; j++) {
            if(score[j] > max) {
                max = score[j];
            }
        }
        System.out.println(max);
        if(score[0] == max) { System.out.println("Adrian"); }
        if(score[1] == max) { System.out.println("Bruno"); }
        if(score[2] == max) { System.out.println("Goran"); }
    }
}
