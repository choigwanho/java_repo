/*<18882번 Cowntact Tracing>
 * */

import java.util.*;
import java.io.*;

class form{
    int t;
    int x;
    int y;
    form(int t, int x, int y){
        this.t = t;
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int T;
    static String str;
    static ArrayList<form> formList;

    static void input(){
        N = scan.nextInt();
        T = scan.nextInt();
        str = scan.next();

        formList = new ArrayList<form>();

        int t,x,y;
        for(int i=0; i<T; i++){
            t = scan.nextInt();
            x = scan.nextInt();
            y = scan.nextInt();
            formList.add(new form(t,x,y));
        }

        formList.sort(new Comparator<form>() {
            @Override
            public int compare(form o1, form o2) {
                return Integer.compare(o1.t, o2.t);
            }
        });
    }

    static void pro(){

    }

    public static void main(String[] args) {
        input();
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