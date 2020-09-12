import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(in.readLine());
        year += 1;

        while (!next_UniqueYear(year)) {
            year++;
        }
        System.out.println(year);
    }

    public static boolean next_UniqueYear(int year) {
        int next = year;
        String y = String.valueOf(next);
        for (int i = 0; i < y.length(); i++) {
           int c = 1;
           for (int j = i+1; j < y.length(); j++) {
              if(y.charAt(i) == y.charAt(j)) {
                 c++;
               }
           }
           if(c > 1) return false;
        }
        return true;
    }
}
