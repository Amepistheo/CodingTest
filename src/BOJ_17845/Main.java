// 17845번 수강 과목
package BOJ_17845;

import java.io.*;
import java.util.*;

public class Main {

    private static int[][] dp = new int[1001][10001];
    private static int[] I, T;

    private static int N, K;

    public static void main(String[] args) throws IOException {
        firstSetting();
        solveProblem();
    }

    private static void firstSetting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        I = new int[K + 1];
        T = new int[K + 1];

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());

            I[i] = Integer.parseInt(st.nextToken());
            T[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solveProblem() {
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if (T[i] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], I[i] + dp[i-1][j-T[i]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[K][N]);
    }
}