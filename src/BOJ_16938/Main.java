// 16938번 캠프 준비
package BOJ_16938;

import java.io.*;
import java.util.*;

public class Main {

    private static int[] level;

    private static int N, L, R, X;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        level = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            level[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(level);

        solve(0, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        System.out.println(answer);
    }

    private static void solve(int index, int count, int sum, int min, int max) {
        if (count >= 2) {
            if (L <= sum && sum <= R && X <= max - min) {
                answer++;
            }
        }

        for (int i = index; i < N; i++) {
            solve(i + 1, count + 1, sum + level[i], Math.min(min, level[i]), Math.max(max, level[i]));
        }
    }
}