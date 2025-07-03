// 1915번 가장 큰 정사각형
package BOJ_1915;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String[] str = br.readLine().split("");

            for (int j = 1; j <= M; j++) {
                dp[i][j] = Integer.parseInt(str[j - 1]);
            }
        }

        int max = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (dp[i][j] == 0) {
                    continue;
                }

                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.print(max * max);
    }
}