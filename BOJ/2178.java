/*
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
}*/

/*<문제>
N*M 크기의 배열
1은 이동할 수 있는 칸, 0은 이동할 수 없는 칸
(1,1)에서 출발하여 (N,M)으로 이동할 때 지나야 하는 최소의 칸 수
다른 칸으로 이동하는 방식은 서로 인접한 칸으로만 이동 -> 상하좌우

<설계 - 자료구조 및 알고리즘>
N,M의 크기가 2에서 100사이 임으로 정수 자료형 사용
각각의 수들은 붙어서 입력으로 주어짐으로 String으로 받아 CharAt으로 가져오기
1,0을 담는 N*M 크기의 2차원 배열을 사용
최단 거리를 구해야하고 인접한 칸을 통해 이동함으로 결과의 값이 최단거리를 보장하는 BFS 알고리즘 사용

<복잡도 검증>
N*M(정점) + 4N*M(간선의 개수) -> 만 단위로 가능

* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static FastReader scan = new FastReader();
    static int N;
    static int M;
    static int[][] maze;

    static int[] dr = new int[] {0,1,0,-1};

    static int[] dc = new int[] {1,0,-1,0};

    public static void main(String[] args){
        input();
        bfs();
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0,1});
        maze[0][0] = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curR = cur[0];
            int curC = cur[1];
            int curCnt = cur[2];

            if (curR==N-1 && curC==M-1) System.out.println(curCnt);

            for(int i=0; i<4; i++){
                int nxtR = curR + dr[i];
                int nxtC = curC + dc[i];

                if (nxtR<0 || nxtR>=N || nxtC<0 || nxtC>=M) continue;
                if (maze[nxtR][nxtC]==1){
                    queue.offer(new int[] {nxtR, nxtC, curCnt+1});
                    maze[nxtR][nxtC] = 0;
                }
            }
        }
    }

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        maze = new int[N][M];
        for(int r=0; r<N; r++){
            String[] strArr = scan.nextLine().split("");
            for(int c=0; c<M; c++){
                maze[r][c] = Integer.parseInt(strArr[c]);
            }
        }
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}