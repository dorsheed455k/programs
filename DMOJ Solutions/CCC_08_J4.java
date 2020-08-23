import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PrefixPostfix {

    static String[] operands = {"+", "-", "/" ,"*"};

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] prefix = in.readLine().split(" ");

        while (!prefix[0].equals("0")) {
            String postFix = preToPos(prefix);
            System.out.println(postFix);

            prefix = in.readLine().split(" ");
        }

    }

    static String preToPos(String[] pre) {

        int len = pre.length-1;

        Stack<String> s = new Stack<>();

        for (int i = len; i >= 0; i--) {
            if(isOperator(pre[i])) {
                String op1 = s.peek(); s.pop();
                String op2 = s.peek(); s.pop();

                String temp = op1 + " " + op2 + " "  + pre[i];
                s.push(temp);
            } else {
                s.push(pre[i]);
            }
        }
        return s.peek();
    }

    static boolean isOperator(String op) {

        for (int i = 0; i < operands.length; i++) {
            if(operands[i].equals(op))  return true;
        }
        return false;
    }
}
