/*<11725번 트리의 부모 찾기>
<문제 설명>
루트가 없는 트리가 주어진다.
트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성해라.
노드의 개수는 2에서 10만개이다.
트리 상에 연결된 두 정점의 정보가 주어진다.

<접근 방법>
루트가 없는 트리 정보가 주어지고, 트리의 루트를 1이라고 정했을 대의 각 노드의 부모를 구해야 하므로
1번 노드로 부터 탐색을 시작하면 연결된 노드들은 자식노드일 것이다.

i번째 노드에서 연결된 노드를 탐색할 때 BFS혹은 DFS 방식으로 탐색할 수 있다.
bfs로 구현하여 풀었다.

<공간 복잡도>
인접행렬로 구현시 메모리 초과
인접행렬로 구현했을 때 O(V*E) -> 1e5*1e5 메모리 256mb(=256(1e6)바이트) 초과

인접리스트로 간선 정보만 저장하여 해결
인접리스트로 BFS탐색을 구현하여 O(V+E) -> 1e5+1e5 메모리 256mb(=256(1e6)바이트) 미만

<시간 복잡도>
인접행렬로 구현시 시간 초과
인접행렬로 구현했을 때 O(V*E) -> 1e5*1e5 시간초과

인접리스트로 간선 정보만 저장하여 해결
인접리스트로 BFS탐색을 구현하여 O(V+E) -> 1e5+1e5

<소요시간>
1시간 20분

<어려웠던 점>
간선의 정보를 저장하는 자료구조를 선정할 때 메모리와 시간복잡도를 고려해야하는 부분이 어려웠습니다.
주로 인접행렬방식을 이용했었는데, 인접리스트로 메모리와 시간복잡도를 줄일 수 있는 방법을 알게 되었습니다.
메모리와 시간복잡도를 생각하여 자료구조를 선정해야겠습니다.

* */

import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> graph;
    static int[] parentNode;
    static int N;

    static void input(){
        N = scan.nextInt(); // 노드의 개수 입력
        graph = new ArrayList<ArrayList<Integer>>(); // 트리의 각 노드에 연결된 노드 번호 기록
        int i;
        for(i=0; i<N+1;i++) graph.add(new ArrayList<Integer>());
        parentNode = new int[N+1]; // i번째 노드의 부모노드 번호 저장

        int v1, v2;
        for(i=1; i<N; i++){
            v1 = scan.nextInt(); // 트리 상에서 연결된 두 정점
            v2 = scan.nextInt();
            graph.get(v1).add(v2); // 연결된 노드의 번호 저장
            graph.get(v2).add(v1);
        }
    }

    static void bfs(int n){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(n);
        while(!q.isEmpty()){
            int parent = q.poll();
            for(int child : graph.get(parent)){
                if (parentNode[child]==0){ // 자식노드의 부모노드를 기록하지 않은 경우
                    parentNode[child]=parent; // 현재 노드를 부모노드로 기록-
                    q.offer(child); // 자식노드를 q에 추가
                }
            }
        }
    }

    static void pro(){
        parentNode[1]=-1;
        bfs(1); // 루트 1에서 부터 자식 노드를 방문하여 부모노드 기록
        for(int i=2; i<N+1; i++) sb.append(parentNode[i]).append("\n");
        System.out.println(sb);
    }

    public static void main(String[] args){
        input();
        pro();
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st==null||!st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
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

