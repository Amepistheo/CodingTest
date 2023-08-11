// 11399번 ATM
package BOJ_11399;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Integer[] people = new Integer[N];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        // 걸리는 시간 오름차순 정렬
        Arrays.sort(people);

        int sum = 0;

        for (int i=0; i<N; i++) {
            sum += (people[i] * (N-i));
        }

        System.out.println(sum);
    }
}