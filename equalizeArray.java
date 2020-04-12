package Classescom.company;

import java.util.Scanner;

public class equalizeArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        in.close();

        int count[] = new int[n];
        int max = count[0];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[j] == arr[i]) {
                    count[i] = count[i] + 1;
                    if (count[i] > max){
                        max = count[i];
                    }
                }
            }
        }
        System.out.print(n - max);
    }
}
