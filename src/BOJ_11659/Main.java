// 11659번 구간 합 구하기 4
package BOJ_11659;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] input = new int[N+1];

        st = new StringTokenizer(br.readLine());

        // 배열에 누적합의 값을 저장
        for (int i=1; i<=N; i++) {
            input[i] = input[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int k=0; k<M; k++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            sb.append(input[j] - input[i-1]).append("\n");
        }

        System.out.print(sb);
    }
}
