import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] xplane = new int[3];
        int[] yplane = new int[3];

        for (int i = 0; i < 3; i++) {
            String[] line = in.readLine().split(" ");
            xplane[i] = Integer.parseInt(line[0]);
            yplane[i] = Integer.parseInt(line[1]);
        }

        if(xplane[0] == xplane[1]) { System.out.print(xplane[2] + " "); }
        if(xplane[1] == xplane[2]) { System.out.print(xplane[0] + " "); }
        if(xplane[0] == xplane[2]) { System.out.print(xplane[1] + " "); }

        if(yplane[0] == yplane[1]) { System.out.println(yplane[2]); }
        if(yplane[1] == yplane[2]) { System.out.println(yplane[0]); }
        if(yplane[0] == yplane[2]) { System.out.println(yplane[1]); }

    }
}
