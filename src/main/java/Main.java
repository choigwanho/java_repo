/*<문제>
직사학형 보드에 빨간 구슬과 파란 구슬을 하나씩 넣은 다음, 빨간 구슬을 구멍을 통해 빼내는 게임

보드의 세로크기는 N, 가로 크기는 M이고, 편의상 1*1크기의 칸으로 나누어져 있다.

가장 바깥 행과 열은 모두 막혀져 있고, 보드에는 구명이 하나 있다.

구슬의 크기는 1*1크기의 칸을 가득 채우는 사이즈이고 빨강, 파랑 하나씩 들어가 있다.

빨간 구슬을 구멍에서 빼내야 하고, 파란 구슬이 구멍에 들어가면 안 된다.

구슬을 손으로 건드릴 수 없고, 중력을 이용해서 굴린다.

왼쪽, 오른쪽, 위, 아래 네 가지 동작이 가능

각 동작에서 공은 동시에 움직인다.

빨간 구슬과 파란구슬이 동시에 구멍에 빠져도 실패이다.

빨간 구슬과 파란 구슬은 동시에 같은 같에 있을 수 없다.

기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지이다.

10번 이하로 빨간 구슬을 구멍을 통해 빼낼 수 있는지 구하는 프로그램을 작성

<전략>
1. 시뮬레이션으로 상하좌우 방향으로 보드를 움직인다.
    - 각 구슬의 다음 위치를 구한다.
    - 위치가 다르면 가능하다.
2. 구슬의 위치로 움직인다.
    - 보드를 복사하여 각각의 케이스를 완전 탐색한다.
3. 빨간 구슬이 10회 이전에 구멍에 도착하는지 확인한다.
    -

* */

import java.io.*;
import java.util.StringTokenizer;
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int M;
    static char[][] board;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, - 1, 1};

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        board = new char[N][M];

        for(int i=0;i<N;i++) {
            String row = scan.nextLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
            }
        }
    }

    static class Pos{
        int x;
        int y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static Pos nextPos(Pos p){

        return new Pos(0,0);
    }

    static boolean simulate(){

        for(int i=0; i<10;i++){






        }

        return true;
    }

    public static void main(String[] args) {
        input();
        if (simulate()) System.out.println(1);
        else System.out.println(0);
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