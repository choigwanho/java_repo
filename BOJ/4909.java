import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static String solve(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[') stack.push(c);
            else if (c == ')') {
                if(stack.empty() || stack.peek() != '(') return "no\n";
                else stack.pop();
            }
            else if (c == ']') {
                if(stack.empty() || stack.peek() != '[') return "no\n";
                else stack.pop();
            }
        }
        if (stack.empty()) return "yes\n";
        else return "no\n";
    }

    public static void main(String[] args) {
        FastReader scan = new FastReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while (true) {
            line = scan.nextLine();
            if(line.equals(".")) break;
            sb.append(solve(line));
        }
        System.out.println(sb);
    }

    static class FastReader {
        BufferedReader br;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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