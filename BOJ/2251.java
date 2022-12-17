/*<문제>
각각 부피가 A,B,C 리터인 세 개의 물통
처음엔 앞의 두 물통은 비어 있고, 세 번째 물통은 가득(C리터) 차 있다.
이제 어떤 물통에 들어있는 물을 다른 물통으로 쏟아 부을 수 있는데, 이때헤는 한 물통이 비거나, 다른 한 물통이 가득 할 때까지 물을 부을 수 있다.
이 과정에서 손실되는 물은 없다고 가정한다.
첫 번째 물통이 비어있을 때, 세 번째 물통에 담겨있을 수 있는 물의 양을 모두 구해내는 프로그램을 작성

<설계- 자료구조, 알고리즘>
뭍통의 내용물이 1에서 200임으로 정수 자료형 사용
물을 이동할 때는 다 비우거나 다 채우는 식으로 이동, 손실은 없음

문제의 탐색 영역을 정의한다.
세 개의 물통을 하나의 페어로 표현할 수 있다. -> 구조체로 표현
200*200*200 -> 8*10^6 8백만가지의 정점의 개수가 정해진다.

상태를 하나의 정점이라고 생각을 하고 현재 상태에서 다른  상태로 변할 수 있는 가지를 간선으로 생각한다.
간선은 8*10^6*6 개가 된다. 3개의 물통에서 서로 부어서 달라질 수 있는 경우의 수이다.

이렇게 그래프의 형태로 생각을 할 수 있고 이제 탐색을 하면된다.

<시간복잡도 검증>


* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class State{
    int[] X;
    State(int[] _X){
        X = new int[3];
        for (int i=0;i<3;i++) X[i] = _X[i];
    }

    State move(int from,int to,int[] Limit){
        int[] nX = new int[]{X[0], X[1], X[2]};
        if (X[from] + X[to] <= Limit[to]){
            nX[to] = nX[from] + nX[to];
            nX[from] = 0;
        }else{
            nX[from] -= Limit[to] - nX[to];
            nX[to] = Limit[to];
        }
        return new State(nX);
    }
}

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[] Limit;
    static boolean[] possible;
    static boolean[][][] visit;

    public static void main(String[] args) {
        input();
        pro();
    }

    static void pro() {
        bfs(0,0, Limit[2]);
        for (int i=0; i<=200; i++){
            if(possible[i]) sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    static void bfs(int x1, int x2, int x3) {
        Queue<State> Q = new LinkedList<>();
        visit[x1][x2][x3] = true;
        Q.add(new State(new int[]{x1,x2,x3}));

        while(!Q.isEmpty()){
            State st = Q.poll();
            if (st.X[0] == 0) possible[st.X[2]] = true;
            for (int from =0; from<3; from++){
                for (int to=0; to<3; to++){
                    if(from==to) continue;
                    State nxt = st.move(from,to,Limit);

                    if(!visit[nxt.X[0]][nxt.X[1]][nxt.X[2]]){
                        visit[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
                        Q.add(nxt);
                    }
                }
            }
        }
    }

    static void input() {
        Limit = new int[3];
        for(int i=0; i<3; i++) Limit[i] = scan.nextInt();
        visit = new boolean[205][205][205];
        possible = new boolean[205];
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
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

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}