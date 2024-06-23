// 11053번 가장 긴 증가하는 부분 수열
package BOJ_11053;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int A = Integer.parseInt(br.readLine());

        int[] seq = new int[A];
        int[] dp = new int[A];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < A; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i = 0; i < A; i++) {
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        Arrays.sort(dp);

        System.out.println(dp[A - 1]);
    }
}