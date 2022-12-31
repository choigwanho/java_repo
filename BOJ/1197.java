/*<1197번 최소 스패닝 트리>
그래프가 주어졌을 때, 그 그래프의 최소 스패닝 트리를 구하는 프로그램을 작성해라.
최소 스패닝 트리는, 주어진 그래프의 모든 정점을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소이 트리를 말한다.

<자료구조>
메모리 제항 -> 8*128*1024*1024
정점의 개수를 저장하는 정수 자료형 -> 32
간선의 개수를 저장하는 정수 자료형 -> 32
A번 정점을 저장하는 정수 자료형 ->32
B번 정점을 저장하는 정수 자료형 ->32
가중치를 저장하는 정수 자료형 -> 32
무방향 그래프를 표현할 인접리스트 -> 10,000 + 100,000
노드의 개수 크기의 부모 테이블 -> 10,001

### 서로소 집합 자료구조
- 서로소 부분 집합들로 나누어진 원소들을 데이터로 처리하기 위한 자료구조
- 합집합(Union): 두 개의 원소가 포함된 집합을 하나의 집합으로 합치는 연산
- 찾기(Find): 특정한 원소가 속한 집합이 어떤 진합인지 확인

<알고리즘>
### 신장트리
- 원본 그래프에서 모든 노드를 포함하면서 사이클이 존재하지 않는 부분 그래프 (트리의 조건과 동일)
### 최소신장트리
- 최소한의 비용으로 구성되는 신장트리


<시간복잡도>

<공간복잡도>

<어려웠던 점>
* */
import java.util.*;
import java.io.*;

// 간선 정보를 저장하는 구조체
class Edge {
    int a, b, c;

    Edge(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
public class Main{
    static FastReader scan = new FastReader();
    static int V;
    static int E;
    static int[] parent;
    static ArrayList<Edge> edgeList;

    static int find(int x){
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]); // root로 parent 압축
    }

    static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if (a==b) return false; // root가 같으면 사이클
        else{
            parent[b]=a;
            return true;
        }
    }

    static void input(){
        V = scan.nextInt();
        E = scan.nextInt();

        parent = new int[V+1]; // 부모 테이블 초기화
        for(int i = 1; i<V+1; i++) parent[i]=i;

        edgeList = new ArrayList<Edge>();

        int a,b,c;
        for (int i=0; i<E; i++){
            a = scan.nextInt();
            b = scan.nextInt();
            c = scan.nextInt();

            edgeList.add(new Edge(a,b,c));
        }

        edgeList.sort(new Comparator<Edge>() { // 간선 비용 기준으로 오름차순 정렬
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.c, o2.c);
            }
        });
    }
    static void pro(){
        int answer = 0;
        for (int i = 0; i < E; i++) {
            Edge edge = edgeList.get(i);
            if(union(edge.a, edge.b)) answer += edge.c;
        }
        System.out.println(answer);
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