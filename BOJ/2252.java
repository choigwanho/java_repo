/*<2252번 줄 세우기>
N명의 학생들을 키 순서대로 줄을 세우려고 한다.
각 학생의 키를 직접 재서 정렬하면 좋지만 키를 재지 못한다.
두 학생의 키를 비교하는 방법으로 정렬을 한다.
모든 학생들을 다 비교해 본 것이 아니라 일부 학생들의 키만들 비교해 보았다.
일부 학생들의 키를 비교한 결과가 주어진다.
줄을 세우는 프로그램을 작성해라.

<자료구조>
N: 학생의 수 -> 2^5*1e3 -> 정수 자료혐
M: 키를 비교한 횟수 -> 1e6 -> 정수 자료형
A,B: 두 학생의 번호 -> 번호는 1~2^5*1e3이고 A가 B의 앞에 서야 한다.

키가 작은 학생앞에 올 수 있는 학생 수를 기록할 수 있는 배열: int[]
키가 큰 학생의 뒤로 올 수 있는 학생을 저장하는 인접리스트: ArrayList<Integer>

<알고리즘>
N명의 학생들을 M번 비교한 정보가 주어진다.
키를 비교한 결과는 선형이며 순환하지 않는다. -> 사이클이 없고, 방향성에 거스르지 않도록 순서가 형성된다.
학생들을 앞에서부터 줄을 세운다.
여러 가지 경우가 있을 경우 아무거나 출력한다.

키가 작은 학생의 앞의 학생수(진입차수)를 기록하여 가장 키가 큰학생(진입차수가 0인 학생)이 앞에 오도록 탐색을 한다.
최초에 본인보다 키가 큰학생이 없는 학생을 큐에 넣고 뒤로 오는 학생보다 앞에올 수 있는 학생 수(진입차수)를 감소시킨다.
그렇게 탐색을 진행하면서 키가 큰 학생들이 빠지면서 키가 작은 학생의 진입차수가 0이 되면(남아있는 학생들 중에서 키가 가장 커지면) q에 넣어준다.

q에 들어간 순서는 graph의 리스트 정렬 순서에 따라 달라 질 수 있고, 선후관계는 보장된다.

<시간 복잡도>
인접 리스트로 진출할(키가 작은 학생)을 그래프로 표현하여 시간복잡도가 O(E+V)로 32,000+100,000 시간 여유가 있다.

<공간 복잡도>
256*8*1024*1024 bit 제한
- 32 bit : 정점의 개수를 저장하는 정수 자료형
- 32 bit : 간선의 개수를 저장하는 정수 자료형
- 32*1000 + 100000 bit: 다음에 올 수 있는 학생을 저장하는 인접 리스트
- 32*(32*1000) bit: 정수 자료형을 담는 큐( 키가 가장 큰 학생들을 순서대로 담는 큐, 연결리스트로 구현되어 크기 가변)
- 32*(32*1000+100000) bit: 결과를 담는 리스트
제한보다 작은 값을 가짐으로 가능하다.

<어려웠던 점>
문제에서 학생의 키를 정점으로 사용하고, 비교하여 얻은 선후관계를 방향으로 하는 그래프까지는 유추가 되었다.
하지만 가장 먼저오는 학생을 지정할 수 있는 방법이 떠오르지 않았다. 앞에서 구현이 막혔음으로 당연하게 다음으로 올 수 있는 학생을 구현하지 못했다.
따라서, 위상정렬을 큐로 구현하는 일반적인 방법을 참고했다.
위상정렬은 순서가 있고, 순환하지 않는 그래프의 형태를 보인다. 문제에서 순환하지 않음을 확인하고 방향성을 유지하는 정렬을 원한다면 위상정렬을 고려할 필요가 있다.
또한, 인접리스트와 큐를 활용하여 구현할 경우 시간 복잡도 또한 BFS와 동일함으로 문제에서 위의 특징으로 구분해서 알고리즘을 선정해야한다.

다음으로 올 수 있는 노드를 저장하는 그래프와 앞에 올 수 있는0(즉, 진입할 수 있는) 노드의 개수를 저장하는 배열을 활용하여 순서를 보장하여 정렬을 하는 방법을 기억하고 활용하자.
<
* */
import java.io.*;
import java.util.*;

public class Main{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[] inDegree;
    static ArrayList<ArrayList<Integer>> listGraph;
    static int N;
    static int M;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        listGraph = new ArrayList<ArrayList<Integer>>();
        int i;
        for(i=0;i<N+1;i++) listGraph.add(new ArrayList<Integer>());
        inDegree = new int[N+1];
        int a,b;
        for(i=0; i<M; i++){
            a = scan.nextInt();
            b = scan.nextInt();
            listGraph.get(a).add(b);
            inDegree[b]++;
        }
    }
    static void topologySort(){
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=1;i<N+1;i++)
            if(inDegree[i]==0) q.offer(i);

        while(!q.isEmpty()){
            int cur = q.poll();
            result.add(cur);
            for(int nxt: listGraph.get(cur)){
                inDegree[nxt]--;
                if(inDegree[nxt]==0) q.offer(nxt);
            }
        }

        for(int i: result) sb.append(i).append(' ');
        System.out.println(sb);
    }

    static void pro(){
        topologySort();
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