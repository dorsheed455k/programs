import java.util.Scanner;

public class LoveLetter {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int l = Integer.parseInt(in.nextLine());
        char[] s = in.nextLine().toCharArray();

        in.close();

        String encrypted = caesar_Cipher(s, l);
        System.out.println(encrypted);
    }

    public static String caesar_Cipher(char[] message, int k) {
        StringBuilder sb = new StringBuilder();
        if(k > 26) {
            k = k%26;
        } else if(k < 0) {
            k = (k % 26) + 26;
        }

        for (int i = 0; i < message.length; i++) {
            char lett = message[i];
            if(lett >= 'a' && lett <= 'z') {
                int x = lett + k;
                if(x > 'z') {
                    x = 'a' + (x - 'z') - 1;
                }
                sb.append((char) x);
            } else if(lett == ' '){
                sb.append(" ");
            }
        }
       return sb.toString();
    }
}
