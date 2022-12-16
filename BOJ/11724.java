/*<문제>
방향 없는 그래프가 주어졌을 때, 연결 요소의 개수를 구해라

<전략>
정점은 1천 간선은 약 50만
같은 간선은 한 번만 주어짐 -> 방향 없음
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static int[][] graph = new int[1001][1001];
    static int V;
    static int E;
    static boolean[] visited = new boolean[1001];

    static void dfs(int node){
        if (visited[node] == true)
            return;
        else {
            visited[node] = true;
            for (int i = 1; i <= V; i++)
                if (graph[node][i] == 1)
                    dfs(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = graph[v][u] = 1;
        }

        int ans = 0;
        for(int i=1; i<=V; i++)
            if (visited[i] == false) {
                dfs(i);
                ans++;
            }

        br.close();
        System.out.println(ans);
    }
}