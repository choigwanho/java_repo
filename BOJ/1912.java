import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static Integer[] dp;
    static int max;
    static FastReader scan = new FastReader();

    static void pro(){
        int N = scan.nextInt();

        arr = new int[N];
        dp = new Integer[N];

        for(int i=0; i<N; i++) {
            arr[i] = scan.nextInt();
        }

        dp[0] = arr[0];
        max = arr[0];

        recur(N - 1);

        System.out.println(max);
    }

    static int recur(int N){
        if(dp[N] == null){
            dp[N] = Math.max(recur(N - 1) + arr[N], arr[N]);
            max = Math.max(dp[N], max);
        }
        return dp[N];
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