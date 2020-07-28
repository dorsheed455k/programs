import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main  {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        String[] str = in.readLine().split(" ");

        quickSort(str, 0, str.length-1);

        for (int i = 0; i < n; i++) {
            System.out.print(str[i] + " ");
        }
    }

     static void quickSort(String[] arr, int start, int end){

        int partition = partition(arr, start, end);

        if(partition-1>start) {
            quickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
            quickSort(arr, partition + 1, end);
        }
    }

     static int partition(String[] arr, int start, int end){
        String pivot = arr[end];

        for(int i=start; i<end; i++){
            if(arr[i].charAt(arr[i].length()-1)<pivot.charAt(pivot.length()-1)){
                String temp= arr[start];
                arr[start]=arr[i];
                arr[i]=temp;
                start++;
            } else if(arr[i].charAt(arr[i].length()-1)==pivot.charAt(pivot.length()-1)) {
                if(Integer.parseInt(arr[i]) > Integer.parseInt(pivot)) {
                    String temp= arr[start];
                    arr[start]=arr[i];
                    arr[i]=temp;
                    start++;
                }
            }
        }

        String temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        return start;
    }
}
