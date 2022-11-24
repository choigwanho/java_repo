import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static long multiple(long a, long b, long c){

        // 지수인 b가 1인 경우 a를 b번 곱하고 c로 나눈 나머지를 구할 수 있다. 로 시작하여 a를 b번 곱하고 c로 나눈 나머지를 구하는 점화식을 도출한다.
        //재귀함수에 밑, 지수, 나누는 값을 파라미터로 넣는다.
        if (b==1) return a%c;

        // 여기서 b가 2,147,483,647이므로 탐색 시간이 오래걸린다. 따라서, 지수법칙 a^(n+m)=a^n*a^m 을 사용하여 log(n)으로 재귀 깊이를 줄여준다.
        long val = multiple(a, b/2, c);

        // 재귀해서 반환해주는 값은 a%c 곱의 누적으로 모듈러 성질을 이용해서 long 범위 내에서 구하려는 값이 나오도록 연산해준다.
        // 짝수인 경우 (a%c*a%c)%c = (a*a)%c
        if (b % 2 == 0) return (val * val) % c;
        // 홀수인 경우  ((a%c*a%c)%c*a)%c = (a*a)%c*a%c = (a*a*a)%c
        else return (val * val) % c * a % c;
    }
    public static void main(String[] args) {
        // 주어진 a,b,c가 2,147,483,647(int max range) 이하의 자연수 이므로 곱셈을 고려해 long type 으로 초기화
        long a = scan.nextInt();
        long b = scan.nextInt();
        long c = scan.nextInt();
        System.out.println(multiple(a,b,c));
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