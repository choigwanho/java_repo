import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt(); // 1,000만
        int[] arr = new int[N];

        for(int i=0; i<N; i++) arr[i]=sc.nextInt();

        /*
         * Arrays.sort() method
         * public static void sort(int[] arr, int from_Index, int to_Index) ;
         * Return Type: NA
         * Complexity Analysis:
         *    Time Complexity: O(N log N)
         *    Auxiliary Space: O(1)
         * 참고: https://www.geeksforgeeks.org/arrays-sort-in-java-with-examples/
         * */
        Arrays.sort(arr); // 약 2,000만으로 가능

        for(int i=0; i<N; i++) sb.append(arr[i]+"\n");

        System.out.println(sb);
    }
}