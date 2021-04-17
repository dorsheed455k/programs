/*
   Breadth First Search Test
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Test {

    static int n, m;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        m = Integer.parseInt(in.readLine());

        ArrayList<Integer>[] arr = new ArrayList[n+1];

        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList();
        }

        for (int i = 0; i < m; i++) {
            String[] ln = in.readLine().split(" ");
            int a = Integer.parseInt(ln[0]);
            int b = Integer.parseInt(ln[1]);
            arr[a].add(b);
            arr[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        vis[0] = true;
        q.add(0);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for(int v: arr[cur]) {
                if (!vis[v]) {
                    vis[v] = true;
                    q.add(v);
                }
            }
        }
        System.out.println(vis[n-1]? "yes" : "no");
    }
}
