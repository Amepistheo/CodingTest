// 15486번 퇴사 2
package BOJ_15486;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] counsel = new int[N + 2][2];
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            counsel[i][0] = Integer.parseInt(st.nextToken());
            counsel[i][1] = Integer.parseInt(st.nextToken());
        }

        int max = -1;

        for (int i = 1; i <= N + 1; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }

            int day = i + counsel[i][0];

            if (day < N + 2) {
                dp[day] = Math.max(dp[day], max + counsel[i][1]);
            }
        }

        System.out.println(dp[N + 1]);
    }
}