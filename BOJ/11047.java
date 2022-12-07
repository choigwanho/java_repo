import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        // N 종류의 동전 배열
        int[] valArr = new int[n];
        for(int i=0; i<n; i++) valArr[i]=Integer.parseInt(br.readLine());

        // 필요한 동전 개수 -> 최소값 구하기
        int cnt = 0;

        // 동전을 적절히 사용하여 가치의 합을 K로 만들기
        for(int i=n-1; i>=0; i--){
            int coin = valArr[i];
            cnt += k / coin;
            // k 값 갱신
            k = k % coin;
        }
        System.out.println(cnt);
    }
}