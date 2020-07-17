import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> str = new ArrayList<>();

        String s = in.readLine();
        str.add(s);

        while (!s.equals("SCHOOL")) {

            s = in.readLine();
            str.add(s);
        }

        Inst(str);
    }

    public static void Inst(ArrayList<String> str) {

        StringBuilder sb = new StringBuilder();

        for (int i = str.size()-1; i >= 1; i--) {
            if(i-1 >= 1) {
                if (str.get(i).equals("R")) {
                    sb.append("Turn LEFT onto ");
                    sb.append(str.get(i-1));
                    sb.append(" street.");
                    sb.append("\n");
                } else if (str.get(i).equals("L")) {
                    sb.append("Turn RIGHT onto ");
                    sb.append(str.get(i-1));
                    sb.append(" street.");
                    sb.append("\n");
                }
            }
        }

        if(str.get(0).equals("R")) {
            sb.append("Turn LEFT into your HOME.");
            sb.append("\n");
        } else if(str.get(0).equals("L")) {
            sb.append("Turn RIGHT into your HOME.");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
