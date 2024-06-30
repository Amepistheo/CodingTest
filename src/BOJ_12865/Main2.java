// 12865번 평범한 배낭
package BOJ_12865;

import java.io.*;
import java.util.*;

public class Main2 {

    private static int[][] dp = new int[101][100001];
    private static int[] W, V;

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

        W = new int[N + 1];
        V = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solveProblem() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (W[i] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], V[i] + dp[i-1][j-W[i]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}