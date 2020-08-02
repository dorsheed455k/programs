import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rövarspråket {

    static String[] vowels = {"a", "e", "i", "o", "u"};

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        String str = in.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
          if(str.charAt(i) != 'a' && str.charAt(i) != 'e' && str.charAt(i) != 'i' && str.charAt(i) != 'o' && str.charAt(i) != 'u') {
              sb.append(str.charAt(i));
              sb.append(closestVowel(str.charAt(i)));
              sb.append(nextConsonant(str.charAt(i)));
          } else {
              sb.append(str.charAt(i));
          }
        }

        System.out.println(sb.toString());
    }

    public static String closestVowel(char c) {
        int[] dis = new int[5];
        String nextVowel = "";
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dis.length; i++) {
            dis[i] = Math.abs(c - vowels[i].charAt(0));
            if(dis[i] < min) {
                min = dis[i];
                nextVowel = vowels[i];
            }
        }
        return nextVowel;
    }

    public static String nextConsonant(char c) {
        int cons = c;
        if(cons == 'z') return String.valueOf('z');
        do {
            cons += 1;
            if(cons > 'z') {
               cons =  'a' + (c - 'z');
                System.out.println((char) cons);
            }
        } while (cons == 'a' || cons == 'e' || cons == 'i' || cons == 'o' || cons == 'u');

        return String.valueOf((char)cons);
    }
}
