import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private Suffix[] suffixes;

    public Main(String txt) {
        int n = txt.length();
        this.suffixes = new Suffix[n];
        for (int i = 0; i < n; i++)
        suffixes[i] = new Suffix(txt, i);
        Arrays.sort(suffixes);
    }

    private static class Suffix implements Comparable<Suffix> {
        private final String text;
        private final int index;

        private Suffix(String text, int index) {
            this.text = text;
            this.index = index;
        }
        private int length() {
            return text.length() - index;
        }
        private char charAt(int i) {
            return text.charAt(index + i);
        }

        public int compareTo(Suffix that) {
            if (this == that) return 0;
            int n = Math.min(this.length(), that.length());
            for (int i = 0; i < n; i++) {
                if (this.charAt(i) < that.charAt(i)) return -1;
                if (this.charAt(i) > that.charAt(i)) return 1;
            }
            return this.length() - that.length();
        }

        public String toString() {
            return text.substring(index);
        }
    }

    public int length() {
        return suffixes.length;
    }

    public int index(int i) {
        if (i < 0 || i >= suffixes.length) throw new IllegalArgumentException();
        return suffixes[i].index;
    }

    public int lcp(int i) {
        if (i < 1 || i >= suffixes.length) throw new IllegalArgumentException();
        return lcpSuffix(suffixes[i], suffixes[i-1]);
    }

    private static int lcpSuffix(Suffix s, Suffix t) {
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) return i;
        }
        return n;
    }

    public String select(int i) {
        if (i < 0 || i >= suffixes.length) throw new IllegalArgumentException();
        return suffixes[i].toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String s;
        for (int k = 0; k < n; k++) {
            s = in.readLine();
            int len = s.length();
            s = s.replaceAll("\\s+", " ").trim();
            Main m = new Main(s);
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                int index = m.index(i);
                assert s.substring(index).equals(m.select(i));
                if (i != 0) {
                    int lcp = m.lcp(i);
                    sum += lcp;
                }
            }
            int res = (len * (len + 1)) / 2;
            System.out.println((res - sum) + 1);
        }

    }
}
