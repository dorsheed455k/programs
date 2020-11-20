import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        String move = in.readLine();
        while (n > 0) {
            if(move.equals("Scissors")) {
                System.out.println("Rock");
            } else if(move.equals("Rock")) {
                System.out.println("Paper");
            } else if(move.equals("Paper")) {
                System.out.println("Scissors");
            } else if(move.equals("Fox")) {
                System.out.println("Foxen");
            }
            if(move.equals("Foxen")) break;
            n--;
            move = in.readLine();
        }
    }
 }
