import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        String init = scan.next();
        LinkedList<Character> linkedList = new LinkedList<>();

        for (char c: init.toCharArray()){
            linkedList.add(c);
        }

        ListIterator<Character> iter = linkedList.listIterator();
        while (iter.hasNext()){
            iter.next();
        }

        int m = scan.nextInt();
        for (int i=0; i<m; i++) { // m개의 명령어 처리
            String tmp = scan.nextLine();
            char c = tmp.charAt(0);
            if (c == 'P') {
                char x = tmp.charAt(2);
                iter.add(x);
            }
            else if (c == 'L') {
                if(iter.hasPrevious()) iter.previous();
            }
            else if (c == 'D') {
                if(iter.hasNext()) iter.next();
            }
            else if (c == 'B') {
                if(iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            }
        }
        for (char c : linkedList){
            sb.append(c);
        }
        System.out.println(sb);
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