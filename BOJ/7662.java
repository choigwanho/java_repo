import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
        풀이 설계
        1. 삽입, 삭제 연산
        2. 우선순위에 다른 최대, 최소 값 탐색 필요
        3. 입력된 요청에 따라 삽입, 최대 삭제, 최소 삭제 -> 로직
        4. 정수를 저장하며 값 자체가 우선순위

        입력
        1. T개의 테스트
        2. K개의 연산 -> 100만 개의 값
            문자 명령어와 정수 값

        출력
        1. 최종적으로 자료구조에 저장된 최대, 최소 출력.
            비어있는 경우 "EMPTY"
    */

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){

            TreeMap<Integer,Integer> treeMap = new TreeMap<>();
            int K = Integer.parseInt(br.readLine());

            for(int j=0;j<K;j++){
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (str.equals("I")) treeMap.put(n, treeMap.getOrDefault(n,0)+1);
                else if (str.equals("D") && n==1 && !treeMap.isEmpty()){
                    int maxKey = treeMap.lastKey();
                    if(treeMap.get(maxKey) == 1) {
                        treeMap.remove(maxKey);
                    }else {
                        treeMap.put(maxKey, treeMap.get(maxKey) - 1);
                    }
                }
                else if (str.equals("D") && n==-1 && !treeMap.isEmpty()){
                    int minKey = treeMap.firstKey();
                    if(treeMap.get(minKey) == 1) {
                        treeMap.remove(minKey);
                    }else {
                        treeMap.put(minKey, treeMap.get(minKey) - 1);
                    }
                }
            }

            if (treeMap.isEmpty()) sb.append("EMPTY\n");
            else {
                sb.append(treeMap.lastKey()+" "+treeMap.firstKey()+"\n");
            }
        }
        System.out.println(sb);
    }
}
