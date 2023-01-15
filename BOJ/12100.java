/*
<12100번 2048(Easy)>
2048 게임
한 번의 이동은 보듸 위에 있는 전체 블록을 상하좌우 네 방향 중 하나로 이동시키는 것
같은 값을 갖는 두 블록이 충돌하면 두 블록은 하나로 합쳐지게 됨
한 번의 이동에서 이미 합쳐진 블록은 또 다른 블록과 다시 합쳐질 수 없음
실제 게임에서는 이동을 한 번 할 때마다 블록이 추가되지만, 이 문제에서 블록이 추가되는 경우는 없음

<입력>
보드의 크기
게임판의 초기 상태

<출력>
최대 5번 이동시켜서 얻을 수 있는 가장 큰 블록을 출력

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static FastReader scan = new FastReader();
    private static int N; // 보드의 크기
    private static int[][] board; // 게임판
    private static int answer;

    private static void input(){
        N = scan.nextInt();
        board = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = scan.nextInt();
        answer = 0;
    }

    private static void output(){
        System.out.println(answer);
    }

    private static void pro(){
        simulate(0);
    }
    private static void simulate(int game){
        if (game == 5) {
            findMax();
            return;
        }

        int[][] board_copy = new int[N][N];
        for(int i = 0; i < N; i++)
            board_copy[i] = board[i].clone();

        for (int i = 0; i < 4; i++){
            move(i);
            simulate(game+1);
            for (int j = 0; j < N; j++)
                board[j] = board_copy[j].clone();
        }
    }
    private static void move(int dir) {
        switch(dir) {
            case 0:
                for(int i = 0; i < N; i++) {
                    int index = 0;
                    int block = 0;
                    for(int j = 0; j < N; j++) {
                        if(board[j][i] != 0) {
                            if(block == board[j][i]) {
                                board[index - 1][i] = block * 2;
                                block = 0;
                                board[j][i] = 0;
                            }
                            else {
                                block = board[j][i];
                                board[j][i] = 0;
                                board[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 1:
                for(int i = 0; i < N; i++) {
                    int index = N - 1;
                    int block = 0;
                    for(int j = N - 1; j >= 0; j--) {
                        if(board[j][i] != 0) {
                            if(block == board[j][i]) {
                                board[index + 1][i] = block * 2;
                                block = 0;
                                board[j][i] = 0;
                            }
                            else {
                                block = board[j][i];
                                board[j][i] = 0;
                                board[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
            case 2:
                for(int i = 0; i < N; i++) {
                    int index = 0;
                    int block = 0;
                    for(int j = 0; j < N; j++) {
                        if(board[i][j] != 0) {
                            if(block == board[i][j]) {
                                board[i][index - 1] = block * 2;
                                block = 0;
                                board[i][j] = 0;
                            }
                            else {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 3:
                for(int i = 0; i < N; i++) {
                    int index = N - 1;
                    int block = 0;
                    for(int j = N - 1; j >= 0; j--) {
                        if(board[i][j] != 0) {
                            if(block == board[i][j]) {
                                board[i][index + 1] = block * 2;
                                block = 0;
                                board[i][j] = 0;
                            }
                            else {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
        }
    }
    private static void findMax() {
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                answer = Math.max(answer, board[i][j]);
    }
    public static void main(String[] args){
        input();
        pro();
        output();
    }

    private static class FastReader {
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