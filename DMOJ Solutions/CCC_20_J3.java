import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        Integer[] pointA =  new Integer[n];
        Integer[] pointB =  new Integer[n];

        for (int i = 0; i < n; i++) {
            String[] x = in.readLine().split(",");
            pointA[i] = Integer.parseInt(x[0]);
            pointB[i] = Integer.parseInt(x[1]);
        }

        int maxX = pointA[0];
        int maxY = pointB[0];
        int minX = pointA[0];
        int minY = pointB[0];

        for (int i = 0; i < n ; i++) {
            if(pointA[i] > maxX) {
                maxX = pointA[i];
            }
            if(pointB[i] > maxY) {
                maxY = pointB[i];
            }

            if(pointA[i] < minX) {
                minX = pointA[i];
            }
            if(pointB[i] < minY) {
                minY = pointB[i];
            }

        }

        System.out.println((minX-1) + "," + (minY-1));
        System.out.println((maxX+1) + "," + (maxY+1));


    }
}
