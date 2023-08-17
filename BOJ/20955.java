import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int N,M, result;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken()); // 뉴런의 개수
        M = Integer.parseInt(st.nextToken()); // 시냅스의 개수

        parents = new int[N+1];
        for(int i=1; i<=N; i++) parents[i] = -1;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken()); // 두 뉴런

            if (!union(u,v)) result++;
        }

        HashSet<Integer> hs = new HashSet<>();
        for (int i=1; i<=N; i++){
            hs.add(find(i));
        }
        result += hs.size() - 1;

        System.out.println(result);

    }
    private static boolean union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u!=v){
            parents[v]=u;
            return true;
        }
        return false;
    }

    private static int find(int n){
        return parents[n] < 0 ? n : (parents[n] = find(parents[n]));
    }
}
