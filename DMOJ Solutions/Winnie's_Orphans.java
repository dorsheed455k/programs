import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        System.out.println(orphan(n,m,in));
    }

    public static int orphan(int n, int m, Scanner in) {

        int min = Integer.MAX_VALUE;
        int minIndex = 0;

        int q = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                int a = in.nextInt();
                if(a == 1 || a == 10) {
                    count++;
                }
            }
            q++;
            if(count < min) {
                min = count;
                minIndex = i+1;
            } else if(count == min) {
                if(q < minIndex) {
                    minIndex = q;
                }
            }
        }

        return minIndex;


    }
}
