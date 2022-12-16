/*<문제>
최대 힙 자료구조 이용하여 다음 연산을 지원하는 프로그램 작성
1. 배열에 자연수 x를 넣는다.
2. 배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거한다.
처음에 비어있는 배열에서 시작한다.

<전략>
연산의 개수 N이 10만 -> 10만개 에서 최대값을 삭제해야 함으로 최대 힙 자료구조 구현
N개의 줄에 연산 정보 x가 주어지고, 입력되는 자연수는 2^31보다 작다.-> 정수 자료형
x가 자연수이면 x값 추가 연산, 0이라면 배열에서 큰 값 출력 -> 조건문 분기 + 구현
* */

/* 해결 코드 1
java PriorityQueue 클래스 사용
PriorityQueue를 사용할 때 add(e), remove(), element()는 예외를 발생시켜서 풀이에서는 offer(e), poll(), peek()를 사용한다.
그리고 PriorityQueue가 null인 경우 조건문으로 처리하기 위해 wrapper class Integer를 사용해서 null 체크를 해주었다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        while(N-- > 0){
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                Integer max = pq.poll();
                if (max == null) sb.append(0).append("\n");
                else sb.append(max).append("\n");
            }
            else pq.offer(x);
        }

        br.close();
        System.out.println(sb);
    }
}
*/


/*코드 개선 1
PriorityQueue를 Collections.reverseOrder()로 최대힙으로 바꾸는 것 보다.
-1을 곱해서 최대힙 효과를 보고, 값을 꺼내 -1을 곱해 원하는 값을 얻는게 미미하게 더 빠르다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        while(N-- > 0){
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                Integer max = pq.poll();
                if (max == null) sb.append(0).append("\n");
                else sb.append(max*-1).append("\n");
            }
            else pq.offer(x*-1);
        }

        br.close();
        System.out.println(sb);
    }
}
*/


/* 코드 개선 2
아무래도 코테에서는 시간 싸움이기 때문에 숏코딩 용으로 코드를 줄여봤다.
null 체크를 pq의 사이즈로 확인하는 삼항 연산자로 변경
Integer class 제거로 메모리와 시간 감소, size() O(1)로 효율적
- Java Collection Big-O 참고: https://www.grepiu.com/post/9

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        while(N-- > 0){
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                sb.append(pq.size()==0?0:pq.poll()).append("\n");
            }
            else pq.offer(x);
        }
        br.close();
        System.out.println(sb);
    }
}
*/

/* 다른 풀이
직접 구현

import java.io.*;
import java.util.*;

class Main{

   static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
   static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
   static StringBuilder sb=new StringBuilder();
   static int N;
   static int heap[]=new int[100001];
   static int top=0;

   public static void main(String args[]) throws Exception {
	   N=Integer.parseInt(br.readLine());
	   for(int i=0;i<N;i++) {
		   int num=Integer.parseInt(br.readLine());
		   if(num==0) {
			   if(top==0) sb.append(0+"\n");
			   else sb.append(pop()+"\n");
		   }
		   else {
			   push(num);
		   }
	   }
	   System.out.println(sb);
   }

   static void swap(int a, int b) {
	   int temp=heap[a];
	   heap[a]=heap[b];
	   heap[b]=temp;
   }

   static void push(int n) {
	   heap[++top]=n;
	   int i=top;
	   while(i>1&&heap[i/2]<heap[i]) {
		   swap(i, i/2);
		   i/=2;
	   }
   }

   static int pop() {
	   int result=heap[1];
	   heap[1]=heap[top];
	   heap[top--]=0;
	   for(int i=1;i*2<=top;) {
		   if(heap[i]>heap[i*2]&&heap[i]>heap[i*2+1]) break;
		   else if(heap[i*2]>heap[i*2+1]) {
			   swap(i, i*2);
			   i=i*2;
		   }
		   else {
			   swap(i, i*2+1);
			   i=i*2+1;
		   }
	   }
	   return result;
   }

}
*/

