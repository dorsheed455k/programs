import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String word = in.nextLine();
        int k = in.nextInt();

        String curStr = word.substring(0,k);
        String min = curStr;


        for (int i = k; i < word.length() ; i++) {
            curStr = curStr.substring(1,k) + word.charAt(i);
            if (min.compareTo(curStr) > 0) {
                min = curStr;
            }
        }
        System.out.println(min);
    }
}
