import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String text;
        
        String[] shorForm = {"CU", ":-)", ":-(", ";-)",
                ":-P", "(~.~)", "TA", "CCC", "CUZ", "TY", "YW", "TTYL"};
                
        String[] translation = {"see you", "I'm happy", "I'm unhappy", "wink",
                "stick out my tongue", "sleepy", "totally awesome", "Canadian Computing Competition",
                "because", "thank-you", "you're welcome", "talk to you later"};
                
        String hold = "";
        String add = "";
        
        do {
             int count = 0;
             text = in.readLine();
             add = text;
             for (int i = 0; i < shorForm.length; i++) {
                if(text.equals(shorForm[i])) {
                    hold = translation[i];
                    count++;
                }
            }
            if(count >= 1) {
                System.out.println(hold);
            } else {
                System.out.println(add);
            }

        } while (!text.equals("TTYL"));
        
    }
}
