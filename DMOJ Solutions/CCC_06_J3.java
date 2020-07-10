import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        String message = in.readLine();

        while (!message.equals("halt")) {
            int seconds = pressTime(message);
            System.out.println(seconds);
            message = in.readLine();
        }
    }

    public static int pressTime(String s) {
        String[][] cellMess = {
              {"a", "2"}, {"b", "22"}, {"c", "222"},
              {"d", "3"}, {"e", "33"}, {"f", "333"},
              {"g", "4"}, {"h", "44"}, {"i", "444"},
              {"j", "5"}, {"k", "55"}, {"l", "555"},
              {"m", "6"}, {"n", "66"}, {"o", "666"},
              {"p", "7"}, {"q", "77"}, {"r", "777"},{"s", "7777"},
              {"t", "8"}, {"u", "88"}, {"v", "888"},
              {"w", "9"}, {"x", "99"}, {"y", "999"},{"z", "9999"},
         };
        int sec = 0;
        for (int i = 0; i < s.length(); i++) {
            char lett = s.charAt(i);
            int num1 = 0;
            int num2 = 0;

            for (int j = 0; j < cellMess.length; j++) {
                char press =  cellMess[j][0].charAt(0);
                 if(lett == press) {
                    num1 = cellMess[j][1].charAt(0);
                    sec += cellMess[j][1].length();
                 }
                if (i > 0) {
                    char prev = s.charAt(i - 1);
                    char prevNum =  cellMess[j][0].charAt(0);
                    if(prev == prevNum) {
                        num2 = cellMess[j][1].charAt(0);
                    }
                }
            }
            if(num1 == num2) {
                sec += 2;
            }
        }
        return sec;
    }
}
