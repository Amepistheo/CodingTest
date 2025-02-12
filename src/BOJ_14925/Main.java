// 14925번 목장 건설하기
package BOJ_14925;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] ground = new int[M + 1][N + 1];
        int[][] dp = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (ground[i][j] != 0) {
                    continue;
                }

                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
    }
}