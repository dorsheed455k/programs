import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        FastReader in = new FastReader();
        int n, k;

        n = in.nextInt();
        k = in.nextInt();

        int[] y = new int[100];
        int[] r = new int[100];
        int[] w = new int[100];

        for (int i = 0; i < n; i++) {
            y[i] = 0;
            w[i] = 1;
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++)
                y[j] += in.nextInt();

            for (int j = 0 ; j < n ; j++) {
                int t = 1;
                for (int l = 0 ; l < n ; l++)
                    if (l != j && y [l] > y [j])
                        t++;
                if (t > w [j])
                    w[j] = t;
                r[j] = t;
            }
        }

        for (int i = 0; i < n; i++) {
            if(r[i] == 1) {
                System.out.printf("Yodeller %d is the TopYodeller: score %d, worst rank %d\n", (i+1), y[i], w[i]);
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
