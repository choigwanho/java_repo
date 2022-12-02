import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static int getSum(String s){
        int sum=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9') sum+=s.charAt(i)-'0';
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 기타의 개수 N, 최대 50개
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        // 시리얼 넘버, 길이, 숫자만의 합을 객채로 생성하여 추가
        for(int i=0; i<N; i++) arr[i] = br.readLine();


        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 길이가 짧은 순으로 정렬
                if(o1.length()<o2.length()) {
                    return -1;
                }
                else if(o1.length()==o2.length()) {
                    // 길이가 같고, 합이 같은 경우 -> String 아스키 값 비교
                    if(getSum(o1)==getSum(o2)) {
                        return o1.compareTo(o2);
                    }
                    // 길이가 같고, 합이 다른 경우
                    else {
                        return Integer.compare(getSum(o1), getSum(o2));
                    }
                }
                else {
                    return 1;
                }
            }
        });
        for(int i=0; i<N; i++) sb.append(arr[i]).append("\n");
        System.out.println(sb);
    }
}