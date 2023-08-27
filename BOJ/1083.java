import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void pro(){
        int N = scan.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<N; i++) arr.add(scan.nextInt());

        int S = scan.nextInt();

        int moveCnt = 0, changeIdx = 0;
        while (moveCnt < S && changeIdx < N - 1) {
            int maxNum = arr.get(changeIdx), maxIdx = -1;

            int idx = changeIdx + 1, count = 1;
            while (moveCnt + count <=S && idx <N) {
                int num = arr.get(idx);
                if (num > maxNum) {
                    maxNum = num;
                    maxIdx = idx;
                }
                count++;
                idx++;
            }
            if (maxIdx != -1) {
                arr.remove(maxIdx);
                arr.add(changeIdx, maxNum);
                moveCnt += maxIdx - changeIdx;
            }
            changeIdx++;
        }
        for (int i : arr) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
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