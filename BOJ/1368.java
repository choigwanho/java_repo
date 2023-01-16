/*
<1368번 물대기>
N개의 논에 물을 대는 문제
물을 대는 방법은 두가지
하나는 직접 논에 우물을 파는 방법
다른 하나느 이미 물을 대고 있는 다른 논으로 부터 물을 끌어오는 방법
각각의 논에 대해 우물을 파는 비용과 논들 사이에 물을 끌어오는 비용들이 주어졌을 때 최소의 비용으로 논에 물을 대는 문제

<접근>
주어진 문제에서 N개의 논은 노드이고 논 사이 간선들의 가중치가 부여된다.
이 그래프에서 모든 정점을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리를 찾으면 문제에서 요구하는 결과를 구할 수 있다.

최대 간선의 개수는 논의 개수, 즉 노드의 개수가 300일 때 300(300-1)/2 = 150*299 = 약 3만 개가 된다.

<입력>
논의 수 300
i번째 논에 우물을 팔 때 드는 비용 10만
i번째 논과 j번째 논을 연결하는데 드는 비용 10만

<출력>
모든 논에 물을 대는데 필요한 최소비용 출력

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    private static FastReader scan = new FastReader();
    private static int N; // 논의 수 (정점 개수)
    private static int[] wArr; // 직접 우물을 팔때 드는 비용 저장
    private static int[] parents; // 서로소 배열
    private static PriorityQueue<Edge> pq = new PriorityQueue<>();
    private static int answer = 0;

    private static void input(){
        N = scan.nextInt(); // 논의 수
        wArr = new int[N+1];
        parents = new int[N+1];

        for (int i = 1; i < N+1; i++){
            wArr[i] = scan.nextInt();
            parents[i] = i;
        }

        for (int i = 1; i < N+1; i++){
            String[] row = scan.nextLine().split(" ");
            for (int j = 1; j < N+1; j++){
                if ( i == j ) pq.add(new Edge(0, i, wArr[i]));
                else if ( i < j) pq.add(new Edge(i,j,Integer.parseInt(row[j - 1])));
            }
        }
    }
    private static void pro(){
        kruskal();
    }
    private static void output(){
        System.out.println(answer);
    }
    private static void kruskal(){
        while (!pq.isEmpty()){
            Edge edge = pq.poll();

            if (find(edge.v1) == find(edge.v2)) continue;

            union(edge.v1, edge.v2);
            answer += edge.w;
        }
    }
    private static void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 > p2) parents[p1] = p2;
        else parents[p2] = p1;
    }
    private static int find(int v) {
        if (parents[v] == v) return v;
        return find(parents[v]);
    }
    public static void main(String[] args){
        input();
        pro();
        output();
    }
    private static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int w;
        public Edge(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }
        @Override
        public int compareTo(Edge e) {
            return w - e.w;
        }
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