import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int row;
    int col;

    public Pair (int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Main {
    static FastReader scan = new FastReader();

    static int n;
    static int m;
    static int[][] paper = new int[500][500];
    static Boolean[][] vis = new Boolean[500][500];
    static int[] DROW = {-1,1,0,0};
    static int[] DCOL = {0,0,-1,1};
    static int DIR_NUM = 4;

    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();
        for (int i=0; i<n; i++)
            for (int j=0; j<m; j++)
                paper[i][j]= scan.nextInt();
    }

    static Boolean OOB(int x, int y){

    }

    static int bfs(int x, int y){
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(x,y));
        vis[x][y]= true;

        while (!q.isEmpty()) {
            Pair curPair = q.remove();
            for (int dir=0; dir<DIR_NUM; dir++){
                int nxtRow = curPair.row-DROW[dir];
                int nxtCol = curPair.col-DCOL[dir];
                Pair nxtPair = new Pair(nxtRow,nxtCol);
                if ()
            }

        }

    }

    public static void main(String[] args) {
        int numPic = 0;
        int maxArea = 0;

        input();
        for (int i=0; i<n; i++)
            for (int j=0; j<m; j++)
                if(vis[i][j] == false) {
                    maxArea = Math.max(maxArea, bfs(i,j)) ;
                    numPic++;
                }

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