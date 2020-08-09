import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] time = in.readLine().split(":");
        int hh = Integer.parseInt(time[0]);
        int mm = Integer.parseInt(time[1]);

        int  dep = hh*60 + mm;
        int arr = dep;
        System.out.println(arrival_Time(dep, arr));

    }

    public static String arrival_Time(int dep, int arr) {
        StringBuilder sb = new StringBuilder();
        int i = dep;

        for (; i < dep+120; i++) {
            if(arr >= 420 && arr < 600) {
                arr += 2;
            } else if(arr >= 900 && arr < 1140) {
                arr += 2;
            } else {
                arr += 1;
            }
            if(arr == 1440) {
                arr = 0;
            }
        }

        int count = 0;

        while (arr >= 60) {
            arr -= 60;
            count++;
        }
        int currentMinute = arr;
        zeroPadding(sb, count, currentMinute);
        return sb.toString();
    }

    public static void zeroPadding(StringBuilder sb, int hh, int mm) {
        if(hh < 10) {
            sb.append("0");
            sb.append(hh);
            sb.append(":");
        } else {
            sb.append(hh);
            sb.append(":");
        }

        if(mm < 10) {
            sb.append("0");
            sb.append(mm);
        } else {
            sb.append(mm);
        }
    }
}
