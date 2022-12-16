/*<문제>
 * 연병장 일렬로 이어진 N개의 칸
 * 각 칸마다 높이를 가짐
 * 첫 번째 칸부터 순서대로 1,2,3,...,N번 칸 명칭이 붙어있음
 * 조교들은 총 M명이 있음
 * 각 조교들은 태상이에게 a번 칸부터 b번칸까지 높이 K만큼 흙을 덮거나 파라고 지시
 * 흙은 무한함
 * 태상이는 각 조교의 지시를 모아 연병장 각 칸의 최종 높이를 미리 구해 한 번에 일을 수행하려고 한다.
 * 조교들의 지시를 모두 수행한 뒤 연병장 각 칸의 높이를 구해라
 *
 * <전략>
 * 일렬로 연결된 선형자료구조
 * 각 조교는 테스트 케이스
 * a,b는 범위
 * 누적을 할 배열과 기존 배열을 분리해서 배열의 인덱스에서 최종으로 연산할 값을 구해서 해결한다.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        int[] arrK = new int[N+2];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            arrK[a]+=k;
            arrK[b+1]-=k;
        }

        for(int i=1; i<N+1; i++){
            arrK[i] += arrK[i-1];
            arr[i]+=arrK[i];
            sb.append(arr[i]).append(" ");
        }

        br.close();
        System.out.println(sb);
    }
}