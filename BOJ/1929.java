/*
<1929번 소수 구하기>
시간 제한 2초, 메모리 제한 256MB
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성


*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int M = scanner.nextInt(); // 100만
        int N = scanner.nextInt(); // 100만

        ArrayList<Boolean> primeList;

        primeList = new ArrayList<Boolean>(N+1);

        primeList.add(false); // index 0
        primeList.add(false); // index 1

        for (int i=2; i<=N;i++) primeList.add(i,true);

        for (int i=2; (i*i)<=N;i++){
            if(primeList.get(i)){
                for(int j = i*i; j<=N; j+=i) primeList.set(j,false);
            }
        }

        for (int i=M; i<=N; i++){
            if(primeList.get(i)==true) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}