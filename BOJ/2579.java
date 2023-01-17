/*
<2579번 계단 오르기>
계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임
각각의 계단에는 일정한 점수가 쓰여있고 계단을 밟으면 그 점수를 얻는다
1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다
2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
3. 마지막 도착 계단은 반드시 밟아야 한다.

각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static FastReader scan = new FastReader();
    private static int n; // 계단의 수
    private static int[] stair; // 계단 점수
    private static int[] dp;

    private static void input(){
        n = scan.nextInt();
        stair = new int[n+1];
        for (int i = 1; i < n+1; i++){
            stair[i] = scan.nextInt();
        }
        dp = new int[n+1];
    }
    private static void pro() {

        dp[1] = stair[1];

        if (n >= 2) {
            dp[2] = stair[1] + stair[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] , dp[i - 3] + stair[i - 1]) + stair[i];
        }

        System.out.println(dp[n]);
    }
    public static void main(String[] args){
        input();
        pro();
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
    }
}