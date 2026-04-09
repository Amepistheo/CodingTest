// 18353번 병사 배치하기
package BOJ_18353;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N];
        int[] count = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        int maxCnt = 0;

        for (int i = 0; i < N; i++) {
            count[i] = 1;

            for (int j = 0; j < i; j++) {
                if (dp[j] > dp[i]) {
                    count[i] = Math.max(count[i], count[j] + 1);
                }
            }

            maxCnt = Math.max(maxCnt, count[i]);
        }

        System.out.println(N - maxCnt);
    }
}