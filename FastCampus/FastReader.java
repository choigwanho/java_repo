/*
2022.05.17 (화)
[Java] 백준 입력 템플릿 By 류호석
참고자료: https://boomrabbit.tistory.com/169
*/

import java.io.*;
import java.util.*;

public class FastReader {
    static StringBuilder sb = new StringBuilder();
    BufferedReader br;
    StringTokenizer st;
    
    public FastReader(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    public FastReader(String s) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(new File(s)));
    }
    String next() {
        while(st == null || ! st.hasMoreElements()) {
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
