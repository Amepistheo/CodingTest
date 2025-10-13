// 1106번 호텔
package BOJ_1106;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] city = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            city[i][0] = Integer.parseInt(st.nextToken());
            city[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[C + 100];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = city[i][1]; j < C + 100; j++) {
                if (dp[j - city[i][1]] == Integer.MAX_VALUE) {
                    continue;
                }

                dp[j] = Math.min(dp[j], dp[j - city[i][1]] + city[i][0]);
            }
        }

        int money = Integer.MAX_VALUE;

        for (int i = C; i < C + 100; i++) {
            money = Math.min(money, dp[i]);
        }

        System.out.println(money);
    }
}