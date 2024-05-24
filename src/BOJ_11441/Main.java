// 11441번 합 구하기
package BOJ_11441;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            num[i] = num[i-1] + Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            int sum = num[j] - num[i-1];

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }
}