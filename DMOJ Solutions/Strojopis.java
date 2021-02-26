import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Strojopis {

    static String[] type = {"1QAZ","2WSX",
            "3EDC","4RFV5TGB","6YHN7UJM",
            "8IK,","9OL.","0P;//-=[]'"};

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] qtd = new int[type.length];
        String[] niz = in.readLine().split("");

        boolean valid = false;
        for (int i = 0; i < niz.length; i++) {
            for (int j = 0; j < type.length; j++) {
                if(type[j].contains(niz[i])) {
                    qtd[j]++;
                    valid = true;
                    break;
                }
            }
            if (!valid) {
                System.out.print("Invalid Input");
            }
        }

        for (int i = 0; i < qtd.length; i++) {
            System.out.println(qtd[i]);
        }
    }
}
