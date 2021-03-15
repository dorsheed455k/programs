import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Deforestation {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int MAX = 1000000;
    static int [] m_i = new int[MAX];
    static int n, q;
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(in.readLine());

        for(int i = 0; i < n ; i ++) {
            String[] t = in.readLine().split(" ");
            if(i!=0) {
                m_i[i] = m_i[i-1] + Integer.parseInt(t[0]);
            }else {
                m_i[0] = Integer.parseInt(t[0]);
            }
        }

        q = Integer.parseInt(in.readLine());
        deforest();
    }

    public static void deforest() throws IOException {
        for (int i = 0; i < q; i++) {
            String[] t = in.readLine().split(" ");
            int a = Integer.parseInt(t[0]);
            int b = Integer.parseInt(t[1]);
            if (a == 0) {
                System.out.println(m_i[b]);
            } else {
                System.out.println(m_i[b] - m_i[a-1]);
            }
        }
    }
}
