/*
<11729번 하노이 탑 이동 순서>
시간 제한 1초, 메모리 제한 256MB
세 개의 장대가 있음
첫 번째 장데어는 반경이 서로 다른 n개의 원판이 쌓여있음
각 원판은 반경이 큰 순서대로 쌓여있음
- 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있음
- 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 함
위의 두 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 함
이동 횟수는 최소가 되어야 하며, 이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성

<자료구조>
첫 번째 장대에 쌓인 원판의 개수 N (1<=N<=20)
세 개의 장대 int[]
이동 정보를 저장하는 구조체

<알고리즘>

* */


import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();    // 첫 번째 장대에 쌓인 원판의 개수

        int k;    // 옮긴 횟수

        System.out.println();
    }
}