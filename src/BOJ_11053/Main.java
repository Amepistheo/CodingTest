// 11053번 가장 긴 증가하는 부분 수열
package BOJ_11053;

import java.io.*;
import java.util.*;

public class Main {

    private static int[] seq;
    private static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int A = Integer.parseInt(br.readLine());

        seq = new int[A];
        dp = new Integer[A];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < A; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < A; i++) {
            LIS(i);
        }

        int max = 0;

        for (int i = 0; i < A; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    private static int LIS(int n) {
        if (dp[n] == null) {
            dp[n] = 1;

            for (int i = n-1; i >= 0; i--) {
                if (seq[i] < seq[n]) {
                    dp[n] = Math.max(dp[n], LIS(i) + 1);
                }
            }
        }

        return dp[n];
    }
}