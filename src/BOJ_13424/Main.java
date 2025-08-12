// 13424번 비밀 모임
package BOJ_13424;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] dp = new int[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) {
                        continue;
                    }

                    dp[i][j] = 100000;
                }
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                dp[a][b] = c;
                dp[b][a] = c;
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                    }
                }
            }

            int K = Integer.parseInt(br.readLine());
            int[] friend = new int[K];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < K; i++) {
                friend[i] = Integer.parseInt(st.nextToken());
            }

            int min = Integer.MAX_VALUE;
            int location = 0;

            for (int i = 1; i <= N; i++) {
                int length = 0;

                for (int j = 0; j < K; j++) {
                    length += dp[friend[j]][i];
                }

                if (length < min) {
                    min = length;
                    location = i;
                }
            }

            sb.append(location).append("\n");
        }

        System.out.print(sb);
    }
}