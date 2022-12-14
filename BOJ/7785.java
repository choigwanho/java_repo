import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //로그에 기록된 출입 기록의 수 n input, 2 <= n <= 10**6
        int n = Integer.parseInt(br.readLine());

        // 초기값 지정
        HashMap<String, Boolean> hm = new HashMap<String, Boolean>();

        // n개의 줄에 출입 기록 input, 사람의 이름,"enter"/"leave"
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 회사에는 동명이인이 없음으로 이름을 dictionary의 key로 사용가능
            String name = st.nextToken();
            String status = st.nextToken();
            if (status.equals("enter")) hm.put(name,true);
            else if (status.equals("leave")) hm.put(name,false);
        }

        // 현재 회사에 있는 모든 사람을 구하기
        LinkedList<String> ansList = new LinkedList<>();
        Iterator<Map.Entry<String,Boolean>> entries = hm.entrySet().iterator();
        while(entries.hasNext()){
            Map.Entry<String,Boolean> entry = entries.next();
            if (entry.getValue()) ansList.push(entry.getKey());
        }

        // 현재 회사에 있는 사람의 이름을 사전 순의 역순으로 한 줄에 한 명씩 출력
        Collections.sort(ansList, Collections.reverseOrder());
        for(String name : ansList) System.out.println(name);
    }
}