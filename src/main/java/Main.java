import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M; // 지도의 크기 n과 m
    static int map[][]; // 지도
    static int distance[][];  // 거리 기록
    static boolean isVisited[][];  // 방문 확인
    static int moveX[] = {0,1,0,-1};
    static int moveY[] = {-1,0,1,0};
    static Point target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /* 첫 줄 지도의 크기 */
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        map = new int[N][M];
        distance = new int[N][M];
        isVisited = new boolean[N][M]; 

        /* 세로의 길이 만큼 지도 입력 */
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if(temp==2){
                    target = new Point(i,j);
                }
            }
        }

        bfs();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(distance[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean Range(int i, int j) {
        if(1<=i && i<=N && 1<=j && j<=M)
            return true;
        return false;
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(target);
        isVisited[target.y][target.x] = true;  // 목적지에서부터 거리 시작

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                Point po = queue.poll();

                for(int d=0; d<4; d++) {
                    int newY = po.y + moveY[d];
                    int newX = po.x + moveX[d];

                    if(!Range(newY, newX))
                        continue;
                    if(isVisited[newY][newX])
                        continue;
                    if(map[newY][newX] == 0 )
                        continue;
                    
                    distance[newY][newX] = distance[po.y][po.x] + 1;
                    isVisited[newY][newX] = true;
                    queue.add(new Point(newX,newY));
                }
            }
        }
    }
}