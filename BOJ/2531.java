import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, d, k, c;
    static int[] sushi;
    static FastReader scan = new FastReader();

    static void pro(){
        n = scan.nextInt();
        d = scan.nextInt();
        k = scan.nextInt();
        c = scan.nextInt()-1;
        sushi = new int[n];
        int[] eat = new int[d];

        for(int i=0; i<n; i++) sushi[i] = scan.nextInt()-1;

        int res = 0;
        int cnt = 0;

        for(int i = 0; i<k; i++) {
            if(eat[sushi[i]]++ == 0) cnt++;
        }

        for(int i = 0; i<n; i++){
            if(res<=cnt){
                if(eat[c] == 0) res = cnt+1;
                else res = cnt;
            }

            int j = (i+k)%n;
            if(eat[sushi[j]]++==0) cnt++;
            if(--eat[sushi[i]]==0) cnt--;
        }
        System.out.println(res);
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