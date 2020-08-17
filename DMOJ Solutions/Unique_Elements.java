import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UniqueElement {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> unique = new ArrayList<>();

        int n = Integer.parseInt(in.readLine());

        while (n > 0) {
            int num = Integer.parseInt(in.readLine());
            if(!unique.contains(num)) {
                unique.add(num);
            }
            n--;
        }
        System.out.println(unique.size());
    }
}
