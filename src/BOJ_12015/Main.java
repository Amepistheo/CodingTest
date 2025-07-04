// 12015번 가장 긴 증가하는 부분 수열 2
package BOJ_12015;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int A = Integer.parseInt(br.readLine());

        int[] arr = new int[A];
        int[] dp = new int[A];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        int length = 1;

        for (int i = 1; i < A; i++) {
            if (dp[length - 1] < arr[i]) {
                dp[length] = arr[i];
                length++;
            } else {
                int left = 0;
                int right = length;

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (dp[mid] < arr[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                dp[left] = arr[i];
            }

        }

        System.out.println(length);
    }
}