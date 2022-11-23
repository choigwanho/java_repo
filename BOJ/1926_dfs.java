import java.io.*;
import java.util.Stack;
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

    static int dfs(int[][] paper, int[][] vis, int x, int y, int row, int col){

        int[] DROW = {-1,1,0,0};
        int[] DCOL = {0,0,-1,1};
        int area = 1;
        Stack<Pair> stack = new Stack<>();

        stack.push(new Pair(x,y));
        vis[x][y]= 1;

        while (!stack.empty()) {
            Pair cur = stack.pop();
            for (int dir=0; dir<4; dir++){
                int nx = cur.row-DROW[dir];
                int ny = cur.col-DCOL[dir];
                if (!(nx<0 || nx>=row || ny<0 || ny>=col) && vis[nx][ny]==0 && paper[nx][ny]==1) {
                    vis[nx][ny] = 1;
                    stack.push(new Pair(nx,ny));
                    area++;
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int row = scan.nextInt();
        int col = scan.nextInt();
        int[][] paper = new int[row][col];
        for (int i=0; i<row; i++)
            for (int j=0; j<col; j++)
                paper[i][j]= scan.nextInt();
        int[][] vis = new int[row][col];

        int numPic = 0;
        int maxArea = 0;

        for (int i=0; i<row; i++)
            for (int j=0; j<col; j++)
                if(vis[i][j] == 0 && paper[i][j]==1) {
                    maxArea = Math.max(maxArea, dfs(paper, vis, i, j, row, col)) ;
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