// 4095번 최대 정사각형
package BOJ_4095;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            int[][] dp = new int[N + 1][M + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 1; j <= M; j++) {
                    dp[i][j] = Integer.parseInt(st.nextToken());
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

            sb.append(max).append("\n");
        }

        System.out.print(sb);
    }
}