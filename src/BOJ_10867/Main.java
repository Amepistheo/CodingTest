// 10867번 중복 빼고 정렬하기
package BOJ_10867;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] number = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(number);

        for (int i=0; i<N-1; i++) {
            if (number[i] != number[i+1]) {
                sb.append(number[i]).append(" ");
            }
        }

        sb.append(number[N-1]);

        System.out.println(sb);
    }
}