import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Group_Assigment {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String name = in.readLine();

        char c = name.charAt(0);

        if (c >= 65 && c <= 73) {
            System.out.println("Group 1.");
            return;
        }
        if(c >= 74 && c <= 83) {
            System.out.println("Group 2.");
            return;
        }

        System.out.println("Group 3.");

    }
}
