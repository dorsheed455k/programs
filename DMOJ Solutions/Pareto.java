/*
  COCI '16 Contest 5 #2 Pareto
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Pareto {

    static ArrayList<Double> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        double n = Integer.parseInt(in.readLine());

        String[] ln = in.readLine().split(" ");
        double sum = 0;
        for (int i = 0; i < n; i++) {
            list.add(Double.parseDouble(ln[i]));
        }
        Collections.sort(list);
        Collections.reverse(list);
        for (int i = 0; i < n; i++) {
            sum += list.get(i);
        }

        double a = 1, b = 1;
        double tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp += list.get(i);
            double ans = tmp/sum - (i + 1)/n;
            if (ans > b - a) {
                a = (i + 1) / n;
                b = tmp / sum;
            }
        }
        a *= 100;
        b *= 100;
        System.out.println(a + "\n" + b);
    }
}
