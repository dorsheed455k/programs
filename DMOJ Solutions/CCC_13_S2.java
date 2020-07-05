import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader (new InputStreamReader (System.in));

        int w = Integer.parseInt(in.readLine());
        int n = Integer.parseInt(in.readLine());

        ArrayList<Integer> c = new ArrayList<Integer>();

        for(int i = 0; i < n; i++){
            if (i < 4){
                c.add(Integer.parseInt(in.readLine()));
            }
            else{
                c.remove(0);
                c.add(Integer.parseInt(in.readLine()));
            }

            int sum = 0;
            for(int j = 0; j < c.size(); j++){
                sum += c.get(j);
            }
            if (sum > w){
                System.out.println((i));
                return;
            }
        }
        System.out.println(n);
           
    }
}
