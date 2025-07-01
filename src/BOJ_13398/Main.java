// 13398번 연속합 2
package BOJ_13398;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        dp1[0] = dp2[0] = arr[0];
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            dp1[i] = Math.max(dp1[i - 1] + arr[i], arr[i]);
            dp2[i] = Math.max(dp2[i - 1] + arr[i], dp1[i - 1]);

            max = Math.max(max, Math.max(dp1[i], dp2[i]));
        }

        System.out.println(max);
    }
}