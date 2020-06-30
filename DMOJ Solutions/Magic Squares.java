import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int[][] square = new int[4][4];
        int[] row = new int[4];
        int[] col = new int[4];
        int r = square.length;
        int c = square[0].length;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                square[i][j] = in.nextInt();
            }
        }

        // column
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                col[i] += square[j][i];
            }
        }

        // row
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                row[i] += square[i][j];
            }
        }
        boolean equal2 = false;
        boolean equal1 = false;
        for (int i = 0; i < row.length; i++) {
            for (int j = i; j < row.length-1; j++) {
                if(row[i] == row[j + 1]) {
                    equal1 = true;
                } else {
                    equal1 = false;
                }
                if(col[i] == col[j + 1]) {
                    equal2 = true;
                } else {
                    equal2 = false;
                }
            }
        }

       if(equal1 && equal2) {
            System.out.println("magic");
        } else {
            System.out.println("not magic");
        }
    }
}
