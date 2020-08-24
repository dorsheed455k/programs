import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Poetry {

    static String[] vowels = {"a", "e", "i", "o", "u"};

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        for (int i = 0; i < n; i++) {

            String[] v1 = in.readLine().split(" ");
            String[] v2 = in.readLine().split(" ");
            String[] v3 = in.readLine().split(" ");
            String[] v4 = in.readLine().split(" ");

            String l1 = v1[v1.length-1].toLowerCase();
            String l2 = v2[v2.length-1].toLowerCase();
            String l3 = v3[v3.length-1].toLowerCase();
            String l4 = v4[v4.length-1].toLowerCase();
            
            l1 = getVowel(l1);
            l2 = getVowel(l2);
            l3 = getVowel(l3);
            l4 = getVowel(l4);

            rhymeType(l1, l2, l3, l4);
        }
    }

    public static String getVowel(String s) {
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < vowels.length; j++) {
                if(s.charAt(i) == vowels[j].charAt(0)) {
                    index = i;
                }
            }
        }
        return s.substring(index);
    }

    public static void rhymeType(String l1, String l2, String l3, String l4) {
        if(l1.equals(l2) && l2.equals(l3) && l3.equals(l4)) {
            System.out.println("perfect");
        } else if(l1.equals(l2)  && l3.equals(l4)) {
            System.out.println("even");
        } else if(l1.equals(l3)  && l2.equals(l4)) {
            System.out.println("cross");
        } else if(l1.equals(l4) && l2.equals(l3)) {
            System.out.println("shell");
        } else {
            System.out.println("free");
        }
    }
}
