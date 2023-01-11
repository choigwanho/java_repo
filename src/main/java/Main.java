import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] dr = new int[]{0,0,-1,1};
    static int[] dc = new int[]{-1,1,0,0};

    public static void main(String[] args){

        int t = scan.nextInt();

        for (int tn = 1; tn <= t; tn++){

            sb.append("#").append(tn).append(" ");

            int[][] city;
            int r = scan.nextInt();
            int c = scan.nextInt();

            city = new int[r][c];
            char[] row;
            for(int i =0; i<r; i++){
                row = scan.nextLine().toCharArray();
                for (int j=0; j<c; j++){
                    city[i][j] = row[j];
                }
            }
            boolean[] checkArr = new boolean['Z'];

            int answer = 0;

            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{0,0,1});

            while(!q.isEmpty()){
                int[] cur = q.poll();
                checkArr[city[cur[0]][cur[1]]] = true;
                city[cur[0]][cur[1]]=0;
                answer = Math.max(cur[2],answer);

                for (int i=0; i<4; i++){
                    int nr = cur[0] + dr[i];
                    int nc = cur[1] + dc[i];

                    if (nr<0||nr>=r||nc<0||nc>=c) continue;

                    if (city[nr][nc]>0 && checkArr[city[nr][nc]]==false){
                        q.offer(new int[]{nr,nc,cur[2]+1});
                    }
                }
            }
            System.out.println();
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
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