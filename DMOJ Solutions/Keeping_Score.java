import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        System.out.println("Cards Dealt              Points");

        int p = 0;
        int index = 0;
        int total = 0;
        str = str.replaceAll("C", "");
        System.out.print("Clubs ");
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'D') {
                total += addSuit(index) + p;
                System.out.print(" " + (addSuit(index) + p));
                System.out.print("\nDiamonds ");
                index = 0; p = 0;
            } else if (str.charAt(i) == 'H') {
                total += addSuit(index) + p;
                System.out.print(" " + (addSuit(index) + p));
                System.out.print("\nHearts ");
                index = 0; p = 0;
            } else if(str.charAt(i) == 'S') {
                    total += addSuit(index) + p;
                    System.out.print(" " + (addSuit(index) + p));
                    System.out.print("\nSpades ");
                    index = 0;
                    p = 0;
            }  else {
                System.out.print(str.charAt(i) + " ");
                p += Points(str.charAt(i));
                index++;
            }
        }

        total += addSuit(index) + p;
        System.out.print(" " + (addSuit(index) + p));

        System.out.printf("\n                       Total %d", total);
    }

    public static int Points(char ch) {
        int p = 0;
        if(ch == 'A') p += 4;
        else if(ch == 'K') p += 3;
        else if(ch == 'Q') p += 2;
        else if(ch == 'J') p += 1;
        return p;
    }

    public static int addSuit(int len) {
        int s = 0;
        if(len >= 3) return 0;
        if(len == 0) s += 3;
        else if(len == 1) s += 2;
        else s += 1;
        return s;
    }
}
