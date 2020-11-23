/*
  CCC_17_J4 - Favourite Times
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.String.valueOf;

public class FavouriteTimes {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int d = Integer.parseInt(in.readLine());
        int h = 12;
        int m = 0;
        int count = 0;
        int i = 0;
        while (i <= d) {
            String hours;
            String minutes;
            if(m == 60) {
                m = m - 60;
                h++;
            }
            if(h == 13) { h -= 12;}
            hours = valueOf(h);
            if(m < 10) {
                minutes = "0" + m;
            } else {
                minutes = String.valueOf(m);
            }
            if(isArithmetic(hours, minutes)) {
           //     System.out.println(hours + ":" + minutes);
                count++;
            }
            m++;
            i++;
        }
        System.out.println(count);
    }

    public static boolean isArithmetic(String hrs, String min) {
        String time = hrs + min;
        int[] arr = new int[time.length()];
        for (int i = 0; i < time.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(time.charAt(i)));
        }
        int count = 0;

        count += nxtArith(arr, 1);
        return count == 1;
    }


    public static int nxtArith(int[] arr, int i) {
        int diff = arr[1] - arr[0];
        int nxt = arr[i-1] + diff;
        if(i == arr.length) {
            return 1;
        }
        if(nxt != arr[i]) {
            return 0;
        } else {
            return nxtArith(arr, i + 1);
        }
    }
}
