import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prase {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        String[] names = new String[100];
        int ret = 0;
        int dosad;
        for (int i = 0; i < n; i++) {
            names[i] = in.readLine();
            dosad = 0;
            for (int j = 0; j < i; j++) {
               if(names[i].equals(names[j])) {
                   dosad = dosad + 1;
               }
            }
            if(dosad > i-dosad) {
                ret++;
            }

        }
        System.out.println(ret);
    }
}
