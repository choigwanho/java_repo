/*<2623번 음악프로그램>
가수의 출연 순서를 정하는 문제
보조 PD가 정한 순서들을 모아서 전체 가수의 순서를 정한다.
전체 가수의 순서를 출력. 단, 순서를 정할 수 없는 경우 0 출력
*/

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        FastReader scan = new FastReader();

        int N = scan.nextInt(); // 가수의 수
        int M = scan.nextInt(); // PD의 수

        ArrayList<ArrayList<Integer>> map = new ArrayList<>();
        for (int i = 0; i <= N; i++)
            map.add(new ArrayList<>());

        int[] inDeg = new int[N+1]; // 진입 차수

        for (int i = 0; i < M; i++){
            String[] temp = scan.nextLine().split(" "); // 보조 pd가 담당한 가수의 수
            for (int j = 1; j < temp.length-1; j++){
                int a,b;
                a = Integer.parseInt(temp[j]);
                b = Integer.parseInt(temp[j + 1]);
                map.get(a).add(b);
                inDeg[b]++;
            }
        }

        /* 큐를 이용한 위상 정렬 알고리즘 */
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>(); // 출력할 순서 저장

        /* 1. 진입 차수가 0인 모든 노드를 큐에 넣음 */
        for (int i = 1; i <= N; i++)
            if (inDeg[i] == 0) q.add(i);

        while (!q.isEmpty()) {
            int cur = q.poll();
            result.add(cur);
            /* 2. 출력된 가수에 연결된 다른 가수의 진입 차수를 감소 후 1의 과정 반복 */
            for (int next : map.get(cur)) {
                inDeg[next]--;
                if (inDeg[next] == 0) q.add(next);
            }
        }

        if (result.size() != N) {
            System.out.println(0);
        }else{
            for (int singer : result) {
                System.out.println(singer);
            }
        }
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