// 11054번 가장 긴 바이토닉 부분 수열
package BOJ_11054;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];

        int[] DP = new int[N];
        int[] RDP = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());

            DP[i] = 1;
            RDP[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (A[j] < A[i]) {
                    RDP[i] = Math.max(RDP[i], RDP[j] + 1);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            DP[i] += RDP[i];
        }

        Arrays.sort(DP);

        System.out.println(DP[N - 1] - 1);
    }
}