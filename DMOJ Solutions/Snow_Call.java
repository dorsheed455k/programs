import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SnowCall {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        for (int i = 0; i < n; i++) {
            String str = in.readLine();
            str = str.replaceAll("-", "");
            char[] phone = str.toCharArray();
            System.out.println(phone_Number(phone));
        }

    }

    public static String phone_Number(char[] s) {
        char[][] cellMess = {
                {'A', '2'}, {'B', '2'}, {'C', '2'},
                {'D', '3'}, {'E', '3'}, {'F', '3'},
                {'G', '4'}, {'H', '4'}, {'I', '4'},
                {'J', '5'}, {'K', '5'}, {'L', '5'},
                {'M', '6'}, {'N', '6'}, {'O', '6'},
                {'P', '7'}, {'Q', '7'}, {'R', '7'},{'S', '7'},
                {'T', '8'}, {'U', '8'}, {'V', '8'},
                {'W', '9'}, {'X', '9'}, {'Y', '9'},{'Z', '9'},
        };

        StringBuilder phoneNum = new StringBuilder();
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < 10; i++) {
            char lett = '0';
            for (char[] cellMess1 : cellMess) {
                if (s[i] == cellMess1[0]) {
                    lett = cellMess1[1];
                }
            }
            if(lett == '0') {
                phoneNum.append(s[i]);
            } else {
                phoneNum.append(lett);
            }
            c1++; c2++;
            if(c1 == 3) {
                phoneNum.append("-");
            }
            if(c2 == 6) {
                phoneNum.append("-");
            }
        }
        return phoneNum.toString();
    }
}
