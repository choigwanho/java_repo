import java.io.*;
import java.util.*;

public class BOJ_15565 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, K;
    static int[] A;
    
    static void input(){
        N = scan.nextInt();
        K = scan.nextInt();
        A = new int[N+1];
        for (int i =1; i <= N; i++){
            A[i] = scan.nextInt();
        }
    }

    static void pro(){
        int R = 0, sum = 0, ans = -1;
        for (int L = 1; L <= N; L++){
            while (R < N && sum < K){ // K개의 라이언이 될 때까지 더하기, 끝에서 종료
                R++;
                if (A[R]==1) sum++;
            }
                
            if (sum == K){ // K개의 라이언이 있는 경우
                if (ans==-1) ans = R-L+1; // 처음은 초기화
                ans = Math.min(ans, R-L+1); // 최소값 갱신
            }

            if (A[L]==1) sum--; // 다음을 카운팅을 위해서 왼쪽 지우기
        }

        System.out.println(ans);  
    }
    
    public static void main(String[] args){
        input();
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
