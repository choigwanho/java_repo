/*<11286번 절댓값 힙>
시간 제한 1초
메모리 제한 256MB

절대값 힙은 다음과 같은 연산을 지원한다.
1. 배열에 정수 x (x!=0)를 넣는다.
2. 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
프로그램은 처음에 비어있는 배열에서 시작하게 된다.

<자료구조>

<알고리즘>

<공간 복잡도>

<시간 복잡도>

<어려웠던 점>

* */

import java.io.*;
import java.util.*;
public class Main{

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N; // 연산의 개수, 1~1e5
    static PriorityQueue<Integer> pq;

    public static void main(String[] args){
        N = scan.nextInt(); // 연산의 개수
        pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // return 이 양수이면 o1, o2 자리 변경
                if (Math.abs(o1)==Math.abs(o2)) return o1-o2; // 양수를 뒤로
                else if (Math.abs(o1)>Math.abs(o2)) return Math.abs(o1)-Math.abs(o2); //큰 값을 뒤로
                else return -1; // 기본 오름차순으로
            }
        });
        int num; // 입력되는 정수
        for (int i=0; i<N; i++){
            num = scan.nextInt();
            if(num==0) sb.append(pq.isEmpty()?0:pq.poll()).append("\n");
            else if(num>0) pq.offer(num);
            else pq.offer(num);
        }
        System.out.println(sb);
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