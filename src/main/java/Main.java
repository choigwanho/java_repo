import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        // 1을 만드는 연산의 횟수의 최소값을 저장하는 배열
        int[] dp = new int[N+1];

        for(int i=2; i<N+1; i++){

            // 2로 나뉠 때 이전 연산 횟수
            int val2 = Math.min(dp[i-1], dp[(int)i/2]);
            // 3으로 나뉠 때 이전 연산 횟수로 갱신
            int val3 = Math.min(dp[i-1],dp[(int)i/3]);

            // 2와 3으로 모두 나뉘면 2로 나뉠 때 값과 3으로 나뉠 때 값중 작은 값에 1을 더해 갱신
            if (i%3==0 && i%2==0) dp[i] = Math.min(val2,val3)+1;
            // 3으로 나뉠 때 이전 연산 횟수에 1을 더해 갱신
            else if(i%3==0 && i%2!=0) dp[i] = val3+1;
            // 2로 나뉠 때 이전 연산 횟수에 1을 더해 갱신
            else if(i%3!=0 && i%2==0) dp[i] = val2+1;
            // 나뉘지 않는 경우, 이전 연산 횟수에 1을 더해 갱신
            else dp[i] = dp[i-1]+1;
        }
        System.out.println(dp[N]);
    }
}