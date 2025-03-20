// 2096번 내려가기
package BOJ_2096;

import java.io.*;
import java.util.*;

public class Main {

    private static int[][] map;
    private static int[][] dp;

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sb.append(maxScore()).append(" ").append(minScore());

        System.out.println(sb);
    }

    private static int minScore() {
        dp = new int[N + 1][3];

        int depth = 1;

        while (depth <= N) {
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    dp[depth][i] = Math.min(dp[depth - 1][i], dp[depth - 1][i + 1]) + map[depth][i];
                } else if (i == 1) {
                    dp[depth][i] = Math.min(dp[depth - 1][i - 1], Math.min(dp[depth - 1][i], dp[depth - 1][i + 1])) + map[depth][i];
                } else if (i == 2) {
                    dp[depth][i] = Math.min(dp[depth - 1][i - 1], dp[depth - 1][i]) + map[depth][i];
                }
            }

            depth++;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[N][i]);
        }
        return min;
    }

    private static int maxScore() {
        dp = new int[N + 1][3];

        int depth = 1;

        while (depth <= N) {
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    dp[depth][i] = Math.max(dp[depth - 1][i], dp[depth - 1][i + 1]) + map[depth][i];
                } else if (i == 1) {
                    dp[depth][i] = Math.max(dp[depth - 1][i - 1], Math.max(dp[depth - 1][i], dp[depth - 1][i + 1])) + map[depth][i];
                } else if (i == 2) {
                    dp[depth][i] = Math.max(dp[depth - 1][i - 1], dp[depth - 1][i]) + map[depth][i];
                }
            }

            depth++;
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            max = Math.max(max, dp[N][i]);
        }
        return max;
    }
}