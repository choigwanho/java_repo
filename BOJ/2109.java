import java.io.*;

import java.awt.Point;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();

    static void pro(){
        int N = scan.nextInt();
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            int p = scan.nextInt();
            int d = scan.nextInt();

            points[i] = new Point(p, d);
        }

        Arrays.sort(points, (p1, p2) -> (p1.x == p2.x) ? p2.y - p1.y : p2.x - p1.x);

        int ans = 0;
        boolean[] check = new boolean[10001];
        for (int i = 0; i < N; i++) {
            for (int j = points[i].y; j >= 1; j--) {
                if (!check[j]) {
                    check[j] = true;
                    ans += points[i].x;
                    break;
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}