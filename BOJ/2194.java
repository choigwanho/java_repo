import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,A,B,K;
    static int arr[][];
    static boolean visit[][];
    static int moveX[] = {0,1,0,-1};
    static int moveY[] = {-1,0,1,0};
    static Point start, end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /* 첫 줄 다섯 개의 정수 */
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        visit = new boolean[N+1][M+1];

        /* 장애물이 설치된 위치 */
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[y][x] = -1;
        }

        /* 시작점 위치 */
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        start = new Point(x,y);

        /* 도착점의 위치 */
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        end = new Point(x,y);

        System.out.println(bfs());
    }
    static boolean Range(int i, int j) {
        if(1<=i && i<=N && 1<=j && j<=M)
            return true;
        return false;
    }
    static boolean isPossible(int i, int j) {
        if(visit[i][j])
            return false;
        for(int i_=i; i_<i+A; i_++) {
            for(int j_=j; j_<j+B; j_++) {
                if(!Range(i_,j_))
                    return false;
                if(arr[i_][j_] == -1)
                    return false;
            }
        }
        visit[i][j] = true;
        return true;
    }
    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visit[start.y][start.x] = true;
        int result = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                Point po = queue.poll();
                if(po.x == end.x && po.y == end.y) {
                    return result;
                }
                for(int d=0; d<4; d++) {
                    int newX = po.x + moveX[d];
                    int newY = po.y + moveY[d];

                    if(!Range(newY, newX))
                        continue;
                    if(!isPossible(newY, newX))
                        continue;

                    queue.add(new Point(newX,newY));
                }
            }
            result++;
        }
        return -1;
    }
}