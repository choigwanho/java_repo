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

    static int row;
    static int col;
    static int[][] paper = new int[500][500];
    static int[][] vis = new int[500][500];
    static int[] DROW = {-1,1,0,0};
    static int[] DCOL = {0,0,-1,1};
    static int DIR_NUM = 4;

    static void input(){
        row = scan.nextInt();
        col = scan.nextInt();
        for (int i=0; i<row; i++)
            for (int j=0; j<col; j++)
                paper[i][j]= scan.nextInt();
    }

    static Boolean OOB(int x, int y){
        return x<0 || x>=row || y<0 || y>=col;
    }

    static Boolean canGo(int x, int y) {
        return !OOB(x,y) && vis[x][y]==0 && paper[x][y]==1;
    }

    static int bfs(int x, int y){
        int area = 1;
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(x,y));
        vis[x][y]= 1;

        while (!q.isEmpty()) {
            Pair curPair = q.remove();
            for (int dir=0; dir<DIR_NUM; dir++){
                int nxtRow = curPair.row-DROW[dir];
                int nxtCol = curPair.col-DCOL[dir];
                if (canGo(nxtRow,nxtCol)) {
                    vis[nxtRow][nxtCol] = 1;
                    q.add(new Pair(nxtRow,nxtCol));
                    area++;
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int numPic = 0;
        int maxArea = 0;

        input();
        for (int i=0; i<row; i++)
            for (int j=0; j<col; j++)
                if( vis[i][j] == 0 && paper[i][j]==1) {
                    maxArea = Math.max(maxArea, bfs(i,j)) ;
                    numPic++;
                }
        System.out.println(numPic);
        System.out.println(maxArea);
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