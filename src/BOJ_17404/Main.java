// 17404번 RGB거리 2
package BOJ_17404;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] home = new int[N + 1][3];
        int[][] dp = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = 10000000;

        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                if (k == i) {
                    dp[1][i] = home[1][i];
                } else {
                    dp[1][i] = 10000000;
                }
            }

            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + home[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + home[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + home[i][2];
            }

            for (int i = 0; i < 3; i++) {
                if (k == i) {
                    continue;
                }

                min = Math.min(min, dp[N][i]);
            }
        }

        System.out.println(min);
    }
}