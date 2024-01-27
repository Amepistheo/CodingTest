// 17124번 두 개의 배열
package BOJ_17124;

import java.io.*;
import java.util.*;

public class Main {

    private static int n, m;
    private static int[] A;
    private static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            A = new int[n];
            B = new int[m];

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);

            long total = getTotal();
            sb.append(total).append("\n");
        }

        System.out.print(sb);
    }

    private static long getTotal() {
        int left = 0;
        int right = 0;
        long total = 0;

        for (int j = 0; j < n; j++) {
            right = Arrays.binarySearch(B, A[j]);

            if (right < 0) {
                right = (right + 1) * (-1);
            }
            if (m <= right) {
                right--;
            }
            if (0 < right) {
                left = right - 1;
            }

            total += getNumer(A[j], left, right);
        }

        return total;
    }

    private static long getNumer(int target, int left, int right) {
        if (Math.abs(target - B[left]) > Math.abs(target - B[right])) {
            return B[right];
        }
        else {
            return B[left];
        }
    }
}