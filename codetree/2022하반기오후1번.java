import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        eventArr = new int[N][N];
        baseCampSet = new HashSet<Location>();
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                int num = scan.nextInt();
                if (num==1) {
                    Location baseCamp = new Location();
                    baseCamp.x = i;
                    baseCamp.y = j;
                    baseCampSet.add(baseCamp);
                }
                eventArr[i][j]=num;
            }
        }
        storeSet = new HashSet<Location>();
        for (int i=0; i<M; i++){
            Location store = new Location();
            store.x = scan.nextInt();
            store.y = scan.nextInt();
            storeSet.add(store);
        }
    }

    static void sol(){

    }

    static class Location {
        int x;
        int y;
    }

    public static void main(String[] args) {
        // m명이 빵을 구하려고 함
        // n번 사람이 n분에 각자의 베이스 캠프에서 출발하여 편의점으로 이동
        // 사람들은 출발 시간이 되기 전에는 격자 밖에 나와 있으며
        // 사람들이 목표로 하는 편의점은 모두 다름
        // n*n 크기의 격자 위에서 진행 됨

        // 3가지 행동으로 움직임
        // 3가지 행동은 총 1분동안 진행됨
        // 1,2,3 순서로 진행됨
        // #1
        // 본인이 가고 싶은 편의점 방향을 향해서 1칸 이동
        // 최단거리가 여러개라면 상좌우하의 우선순위로 이동
        // #2
        // 편의점에 도착하면 멈추고, 그 장소를 다른 사람들이 지나갈 수 없게도미
        // #3
        // 현재 시간이 t분이고 t<=m을 만족한다면
        // t번 사람은 자신이 가고 싶은 편의점과 가장 가까이 있는 베이스 캠프에 들어감
        // 베이스캠프가 여러 가지인 경우에는 그 중 행과 열이 작은 순서로 들어감
        // t번 사람이 베이스 캠프로 이동하는 데에는 시간이 소요되지 않음
        // 해당 베이스 캠프가 있는 칸을 다른 사람들이 지나갈 수 없게됨

        input();
        sol();
    }

    static int N;
    static int M;
    static int[][] eventArr;
    static HashSet<Location> storeSet;
    static HashSet<Location> baseCampSet;

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
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