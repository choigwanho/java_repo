import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();

    static void pro(){
        int N = scan.nextInt();
        int[] numbers = new int[N];

        for(int i =0 ; i < N ; i++) numbers[i] = scan.nextInt();

        Arrays.sort(numbers);

        int result = 0;
        for(int i = 0 ; i < N ; i++){
            int left = 0;
            int right = N-1;
            while(true){

                if(left == i) left++;
                else if(right == i) right--;

                if(left >= right) break;

                if(numbers[left] + numbers[right] > numbers[i]) right--;
                else if(numbers[left] + numbers[right] < numbers[i]) left++;
                else{
                    result++;
                    break;
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        pro();
    }

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
    }
}