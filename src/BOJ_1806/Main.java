// 1806번 부분합
package BOJ_1806;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = arr[0];
        int length = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;

        while (left < N && right < N) {
            if (sum >= S) {
                length = Math.min(length, right - left + 1);

                sum -= arr[left];
                left++;

                if (right < left) {
                    right = left;
                }
            } else {
                right++;
                sum += arr[right];
            }
        }

        if (length == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(length);
        }
    }
}