import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] maze = new int[N][M];
        for(int i=0; i<N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < M; j++){
                maze[i][j] = Integer.parseInt(row[j]);
            }
        }

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x  =temp[0];
            int y  =temp[1];

            if(x == N-1 && y == M-1) {
                System.out.println(maze[N-1][M-1]);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && maze[nx][ny] == 1) {
                    maze[nx][ny] = maze[x][y]+1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}