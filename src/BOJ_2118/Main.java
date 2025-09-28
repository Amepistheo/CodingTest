// 2118번 두 개의 탑
package BOJ_2118;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N + 1];
        dp[1] = 0;

        for (int i = 1; i < N; i++) {
            dp[i + 1] = dp[i] + Long.parseLong(br.readLine());
        }

        long total = dp[N] + Long.parseLong(br.readLine());

        long[] arr = new long[2 * N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = dp[i];
            arr[i + N] = dp[i] + total;
        }

        long length = 0;
        int j = 2;

        for (int i = 1; i <= N; i++) {
            if (j < i + 1) {
                j = i + 1;
            }

            while (j <= i + N && arr[j] - arr[i] <= total / 2) {
                long diff = arr[j] - arr[i];
                long min = Math.min(diff, total - diff);

                if (length < min) {
                    length = min;
                }

                j++;
            }

            if (j <= i + N) {
                long diff = arr[j] - arr[i];
                long min = Math.min(diff, total - diff);

                if (length < min) {
                    length = min;
                }
            }
        }

        System.out.println(length);
    }
}
