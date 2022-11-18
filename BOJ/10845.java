import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<Integer>();
        int last = 0;

        for (int i=0; i<N;i++){
            String[] c = br.readLine().split(" ");
            switch(c[0]){
                case "push":
                    last = Integer.valueOf(c[1]);
                    queue.add(last);
                    break;
                case "pop":
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(queue.remove());
                    }
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if(queue.isEmpty()){
                        System.out.println(1);
                    }else {
                        System.out.println(0);
                    }
                    break;
                case "front":
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }else {
                        System.out.println(queue.peek());
                    }
                    break;
                case "back":
                    if(queue.isEmpty()){
                        System.out.println(-1);
                    }else {
                        System.out.println(last);
                    }
                    break;
            }
        }
        br.close();
    }
}
