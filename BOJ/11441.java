/* <문제>
 * N개의 수 A1,A2,...,An
 * 총 M개의 구간 i,j
 * i번째 수부터 j번째 수까지 합
 *
 * <전략>
 * 구간을 구하기 위해서 선형 자료구조를 생각함
 * 주어진 값의 범위가 |1000| 임으로 정수를 저장하는 배열 자료구조 사용
 * 길이가 1만이고 탐색횟수가 1만이라서 그냥 완전 탐색을 하게 되면 10억으로 비효율적임
 * 시간 복잡도를 줄이기 위해서 구간의 시작과 끝으로 값을 조회할 수 있도록 O(n)으로 누적합을 미리 계산함
 * 누적합의 크기도 1만*1천으로 1000만임으로 정수 자료혐으로 저장이 가능함.
 * */

/*1차 풀이
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] aArr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++)
            aArr[i] = Integer.parseInt(st.nextToken());

        for(int i=2; i<N+1; i++)
            aArr[i] += aArr[i-1];

        int M = Integer.parseInt(br.readLine());
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            sb.append(aArr[j]-aArr[i-1]).append("\n");
        }
        br.close();
        System.out.println(sb);
    }
}
*/

/*코드 개선
* 정수 자료형의 기본값이 0임을 활용해 입력과 동시에 누적합을 구해 반복문을 1회로 줄인다.
* BufferedReader를 close 해주기. JVM이 알아서 종료하기는 하지만 종료하는 것 권장.
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] cumulativeSum = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++)
            cumulativeSum[i] = cumulativeSum[i-1] + Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int prefixSum = cumulativeSum[j]-cumulativeSum[i-1];
            sb.append(prefixSum).append("\n");
        }
        br.close();
        System.out.println(sb);
    }
}