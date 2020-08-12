import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int pos = 1;
        int move = Integer.parseInt(in.readLine());

        while(true) {

            if(pos + move <= 100) {
                pos += move;
            }
            pos =  ladder(pos);
            pos = snakes(pos);

            if(pos >= 100) {
                System.out.println("You are now on square 100");
                System.out.println("You Win!");
                break;
            }
            if(move == 0) {
                System.out.println("You Quit!");
                break;
            }

            System.out.printf("You are now on square %d\n", pos);

            move = Integer.parseInt(in.readLine());
        }

    }

    public static int snakes(int pos) {
        if(pos == 54) {
            pos = 19;
        } else if(pos == 90) {
            pos = 48;
        } else if(pos == 99) {
            pos = 77;
        } else {
            return pos;
        }
        return pos;
    }

    public static int ladder(int pos) {
        if(pos == 9) {
            pos = 34;
        } else if(pos == 40) {
            pos = 64;
        } else if(pos == 67) {
            pos = 86;
        } else {
            return pos;
        }
        return pos;
    }
}
