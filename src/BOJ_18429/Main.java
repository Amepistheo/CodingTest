// 18429번 근손실
package BOJ_18429;

import java.io.*;
import java.util.*;

public class Main {

    private static int[] A;
    private static boolean[] isVisit;

    private static int N, K;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        A = new int[N];
        isVisit = new boolean[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 500);

        System.out.println(count);
    }

    private static void dfs(int day, int weight) {
        if (day == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isVisit[i]) {
                continue;
            }

            if (weight + A[i] - K >= 500) {
                isVisit[i] = true;
                dfs(day + 1, weight + A[i] - K);
                isVisit[i] = false;
            }
        }
    }
}