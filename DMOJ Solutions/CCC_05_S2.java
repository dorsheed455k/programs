import java.util.Scanner;

public class MouseMove {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int c, r;
        c = in.nextInt();
        r = in.nextInt();
        int prevXPos = 0, prevYPos = 0;
        int i = 0;
        while (true) {
            int x = in.nextInt();
            int y = in.nextInt();
            if(x == 0 && y == 0) {
                break;
            } else {
                if(i == 0) { prevXPos = x;prevYPos = y;}
                else { prevXPos += x;prevYPos += y;}
            }

            if(prevXPos < 0) {
                prevXPos = 0;
            } else if(prevXPos > c) {
                prevXPos = c;
            }
            
            if(prevYPos < 0) {
                prevYPos = 0;
            }else if(prevYPos > r) {
                prevYPos = r;
            }

            System.out.println(prevXPos + " " + prevYPos);
            i++;
        }
    }
}
