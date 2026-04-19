// 42898번 등굣길
package PG_42898;

import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int[][] dp = new int[m + 1][n + 1];
        boolean[][] map = new boolean[m + 1][n + 1];

        for (int[] puddle : puddles) {
            map[puddle[0]][puddle[1]] = true;
        }

        dp[1][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j]) {
                    continue;
                }

                if (i > 1) {
                    dp[i][j] += dp[i - 1][j];
                }

                if (j > 1) {
                    dp[i][j] += dp[i][j - 1];
                }

                dp[i][j] %= 1000000007;
            }
        }

        return dp[m][n];
    }
}