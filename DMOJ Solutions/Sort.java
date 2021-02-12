import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Sort {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n, c;

        String[] l1 = in.readLine().split(" ");

        n = Integer.parseInt(l1[0]);
        c = Integer.parseInt(l1[1]);
        int[] arr = new int[n];

        String[] l2 = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(l2[i]);
        }

        Map<Integer, Integer> ele = new LinkedHashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if(ele.containsKey(arr[i])) {
                ele.put(arr[i], ele.get(arr[i])+1);
            } else {
                ele.put(arr[i], 1);
            }
        }

        ArrayList<Entry<Integer, Integer>> listOfEntry = new ArrayList<>(ele.entrySet());

        Collections.sort(listOfEntry, new Comparator<Entry<Integer, Integer>>() {
           @Override
           public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
               return o2.getValue().compareTo(o1.getValue());
           }
           }
        );

        for(Entry<Integer, Integer> entry : listOfEntry) {
            int freq = entry.getValue();
            while (freq >= 1) {
                System.out.print(entry.getKey() + " ");
                freq--;
            }
        }
    }
}
