
/*
<11780번 플로이드 2>
n개의 도시
한 도시에서 출발하여 다른 도시에 도착하는 m개의 버스
각 버스는 비용이 있음
모든 도시의 쌍에 대해서 도시 A에서 B로 가는데 필요한 비용의 최솟값을 구하는 프로그램

<풀이>
모든 정점에서 다른 모든 정점까지의 최단거리를 구하는 문제로 플로이드 알고리즘을 풀 수 있다.
1. dist 배열의 모든 값을 INF로 초기화
2. 출발 노드와 도착 노드가 같은 경우 dist값을 0으로 초기화
3. 그래프에서 주어지는 간선은 dist[form][to] = weight 형태로 저장
4. 모든 정점을 middle로 둔 경우들에 대해서 현재까지 찾은 form-to 가중치와 form-middle + middle-to 가중치의 합을 비교해 더 작은 값으로 갱신
   - dist[from][to] = min(dist[from][to], dist[form][middle]+dist[middle][to])


*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static FastReader scan = new FastReader();
    private static StringBuilder sb = new StringBuilder();

    private static int n; // 도시의 개수
    private static int m; // 버스의 개수
    private static int[][] wArr; // 비용 저장 인접 행렬
    private static final int INF = Integer.MAX_VALUE;
    private static int[][] route;

    private static void input(){
        n = scan.nextInt(); // 도시의 개수
        m = scan.nextInt(); // 버스의 개수 초기화

        wArr = new int[n+1][n+1]; // 간선 가중치 저장 배열 초기화
        for (int i = 1; i < n+1; i++)
            for (int j = 1; j < n+1; j++)
                if (i!=j) wArr[i][j] = INF; // 연결이 안 된 경우를 위해 INF 초기화

        int v1, v2, w; // 시작, 도착, 가중치
        for (int i = 0; i < m; i++){
            v1 = scan.nextInt();
            v2 = scan.nextInt();
            w = scan.nextInt();
            wArr[v1][v2] = w; // 연결이 된 부분 가중치 초기화
        }

        route = new int[n+1][n+1]; // 경로 저장 배열 초기화
    }
    private static void floydWarshall(){
        for (int middle = 1; middle < n+1; middle++){
            for (int from = 1; from < n+1; from++){
                for (int to = 1; to < n+1; to++){
                    if (wArr[from][to] > wArr[from][middle]+wArr[middle][to]){
                        route[from][to] = middle; // middle을 거치므로 저장
                        wArr[from][to] = wArr[from][middle]+wArr[middle][to]; // middle을 거치는 것이 더 빠르다면 갱신
                    }
                }
            }
        }
    }
    private static void output(){

        // i번째 정점에서 j번째 정점까지의 최소비용 출력
        for(int from = 1; from < n+1; from++) {
            for(int to = 1; to < n+1; to++) sb.append(wArr[from][to]).append(" ");
            sb.append("\n");
        }

/*        //
        for(int from=1; from < n+1; from++) {
            for(int to=1; to < n+1; to++) {
                if(from==to) sb.append("0\n");
                else {

                }
            }
        }*/
        System.out.println(sb.toString());
    }
    public static void main(String[] args){
        input();
        floydWarshall();
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