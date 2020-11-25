/*
 CCC'99 S1 - Card Game
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] moves = new String[52];
        int i = 0;
        while (i < 52) {
            moves[i] = in.readLine();
            i++;
        }
        int aPoints = 0;
        int bPoints = 0;
        int reset = 0;
        String curr = "";
        int count = 0;
        for (int j = 0; j < moves.length; j++) {
            if(moves[j].equals("jack") ||
               moves[j].equals("queen") ||
               moves[j].equals("king") ||
               moves[j].equals("ace")) {
                if(count != 1) {
                    curr = moves[j];
                    count = 1;
                    reset = 0;
                } else {
                    if(((j+1)-(reset+1)) % 2 != 0) {
                        int point = playerPoints(curr, reset);
                        aPoints += point;
                        if(point > 0) System.out.println("Player A scores " + point + " point(s).");
                        curr = moves[j];
                        reset = 0;
                    } else if(((j+1)-(reset+1)) % 2 == 0)  {
                        int point = playerPoints(curr, reset);
                        bPoints += point;
                        if(point > 0) System.out.println("Player B scores " + point + " point(s).");
                        curr = moves[j];
                        reset = 0;
                    }
                }

            } else {
               reset++;
            }
        }
        if(reset > 0) {
            int point = playerPoints(curr, reset);
            bPoints += point;
            if(point > 0) System.out.println("Player B scores " + point + " point(s).");
        }
        System.out.println("Player A: " + aPoints + " point(s).");
        System.out.println("Player B: " + bPoints + " point(s).");
    }

    public static int playerPoints(String move, int r) {
        if(move.equals("ace") && r >= 4) {
            return 4;
        } else if(move.equals("king") && r >= 3) {
            return 3;
        } else if(move.equals("queen") && r >= 2) {
            return 2;
        } else if(move.equals("jack") && r >= 1) {
            return 1;
        }
        return 0;
    }
}
