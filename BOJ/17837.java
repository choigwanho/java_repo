import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static final int WHITE = 0;
    static final int RED = 1;
    static final int BLUE = 2;
    static int N, K;
    static int[][] colorMap;
    static Horse[] horse;
    static ArrayList<Integer>[][] board;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static FastReader scan = new FastReader();

    static void pro(){

        N = scan.nextInt();
        K = scan.nextInt();

        colorMap = new int[N+1][N+1];
        board = new ArrayList[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                colorMap[i][j] = scan.nextInt();
                board[i][j] = new ArrayList<>();
            }
        }
        horse = new Horse[K+1];
        for(int ID=1; ID<=K; ID++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int dir = scan.nextInt();
            horse[ID] = new Horse(ID, x, y, dir);
            board[x][y].add(ID);
        }

        for(int turn = 1; turn <= 1000; turn++) {
            for(int idx = 1 ; idx <= K ; idx++) {
                if(move(idx)) {
                    System.out.println(turn);
                    return;
                };
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        pro();
    }

    private static boolean move(int idx) {
        Horse current = horse[idx];

        int nX = current.x + dx[current.dir];
        int nY = current.y + dy[current.dir];

        if(!isRangeValid(nX, nY)) {
            current.changeDirection();
            nX = current.x + dx[current.dir];
            nY = current.y + dy[current.dir];
        }

        if(isRangeValid(nX, nY)) {
            actionByColor(current, nX, nY);
            if(board[nX][nY].size() >= 4) return true;
        }
        return false;
    }

    private static void actionByColor(Horse current, int nX, int nY) {
        ArrayList<Integer> from = board[current.x][current.y];
        ArrayList<Integer> to = board[nX][nY];
        int position = from.indexOf(current.ID);
        int fromSize = from.size();

        switch(colorMap[nX][nY]) {
            case WHITE:
                for(int i = position; i < fromSize; i++){
                    int horseID = from.remove(position);
                    horse[horseID].x = nX;
                    horse[horseID].y = nY;
                    to.add(horseID);
                }
                break;

            case RED:
                for(int i = position; i < fromSize; i++){
                    int horseID = from.remove(from.size()-1);
                    horse[horseID].x = nX;
                    horse[horseID].y = nY;
                    to.add(horseID);
                }
                break;
        }
    }

    private static boolean isRangeValid(int nX, int nY) {
        if( nX > N || nX < 1 || nY > N || nY < 1 || colorMap[nX][nY] == BLUE) {
            return false;
        }
        return true;
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

class Horse{
    int ID, x, y, dir;
    Horse(int ID, int x, int y, int dir){
        this.ID = ID;
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    public void changeDirection() {
        if(dir == 1) dir = 2;
        else if(dir == 2) dir = 1;
        else if(dir == 3) dir = 4;
        else if(dir == 4) dir = 3;
    }
}