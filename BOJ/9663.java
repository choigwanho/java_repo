/*
<9663번 N-Queen>
시간 제한 10초, 메모리 제한 128MB
N-Queen 문제는 크기가 N*N인 체크판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
*/

import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // N*N 체스판의 가로, 세로 값, 1~15

        boolean[] r = new boolean[n]; // 행의 선택 여부
        boolean[] c = new boolean[n]; // 열의 선택 여부

        int answer = 0; // 퀸 N개를 서로 고역할 수 없게 놓는 경우의 수

        if(n==1) answer = 1;
        else if(n==2) answer = 2;



        System.out.println(answer); // 퀸 N개를 서로 고역할 수 없게 놓는 경우의 수 출력
    }
}