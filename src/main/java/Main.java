import java.util.*;
import java.io.*;

public class Main{
    static void func(int n, int m, int k){
        int[] arr = new int[10];
        int[] vis = new int[10];
        if (k==m){
            for(int i=0;i<m;i++){
                System.out.println(arr[i]);
            }
            System.out.println();
        }
        for(int i=1;i<=n;i++){
            if (vis[i]==0){
                arr[k]=i;
                vis[i]=1;
                func(n,m,k+1);
                vis[i]=0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1~8까지의 자연수 n,m 입력. 1부터 n까지 자연수 중에서 중복 없이 m개를 고른 수열
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        func(n,m,0);
    }
}