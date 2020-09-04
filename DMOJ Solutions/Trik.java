import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Trik {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String moves = in.readLine();

        int index = cup_HiddenIn(moves);
        System.out.println(index);
    }

    public static int cup_HiddenIn(String moves) {
        int pos = 1;

        for (int i = 0; i < moves.length(); i++) {
            if(moves.charAt(i) == 'A') {
                pos = 2;
            } else if(moves.charAt(i) == 'B') {
                pos = 3;
            } else if(moves.charAt(i) == 'C') {
                pos = 1;
            }
        }
        return pos;
    }
}
