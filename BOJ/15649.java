import java.util.*;
import java.io.*;

public class Main{

    public static int[] arr;
    public static boolean[] vis;
    public static void dfs(int n, int m, int d){

        if (d==m){
            for(int val : arr){
                System.out.println(val + " ");
            }
            System.out.println();
            return;
        }
        for(int i=1;i<=n;i++){
            if (!vis[i]){
                vis[i]=true;
                arr[d]=i+1;
                dfs(n,m,d+1);
                vis[i]=false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1~8까지의 자연수 n,m 입력. 1부터 n까지 자연수 중에서 중복 없이 m개를 고른 수열
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        vis = new boolean[n];
        dfs(n,m,0);
    }
}