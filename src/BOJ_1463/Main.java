// 1463번 1로 만들기
package BOJ_1463;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        dp[1] = 0;

        if (N == 1) {
            System.out.println(0);
            return;
        }
        else {
            for (int i=2; i<=N; i++) {
                if (i%6 == 0)
                    dp[i] = Math.min(dp[i-1], Math.min(dp[i/3], dp[i/2])) + 1;
                else if (i%2 == 0)
                    dp[i] = Math.min(dp[i-1]+1, dp[i/2]+1);
                else if (i%3 == 0)
                    dp[i] = Math.min(dp[i-1]+1, dp[i/3]+1);
                else
                    dp[i] = dp[i-1]+1;
            }
        }

        System.out.println(dp[N]);
    }
}
