import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class French_Homework {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String verb = in.readLine();
        String obj = in.readLine();

        frenchQuest(verb, obj);
    }

    public static void frenchQuest(String v, String obj) {
        StringBuilder sb = new StringBuilder();

        int len = obj.length();
        if (obj.charAt(len-1) == 'e') {
            sb.append(v);
            sb.append("-tu");
            sb.append(" la ");
            sb.append(obj);
            sb.append(" ?");
        } else if (obj.charAt(len-1) == 's') {
            sb.append(v);
            sb.append("-tu");
            sb.append(" les ");
            sb.append(obj);
            sb.append(" ?");
        } else {
            sb.append(v);
            sb.append("-tu");
            sb.append(" le ");
            sb.append(obj);
            sb.append(" ?");
        }


        System.out.println(sb.toString());
    }
}
