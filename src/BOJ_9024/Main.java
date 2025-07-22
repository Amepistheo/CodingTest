// 9024번 두 수의 합
package BOJ_9024;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            long[] list = new long[n];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                list[i] = Long.parseLong(st.nextToken());
            }

            Arrays.sort(list);

            int left = 0;
            int right = n - 1;
            long min = Long.MAX_VALUE;
            int count = 0;

            while (left < right) {
                long sum = list[left] + list[right];

                if (Math.abs(sum - K) == min) {
                    count++;
                } else if (Math.abs(sum - K) < min) {
                    min = Math.abs(sum - K);
                    count = 1;
                }

                if (sum == K) {
                    left++;
                    right--;
                } else if (sum < K) {
                    left++;
                } else {
                    right--;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}