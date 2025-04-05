// 5014번 스타트링크
package BOJ_5014;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] dp = new int[F + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        boolean[] isVisit = new boolean[F + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        dp[S] = 0;
        isVisit[S] = true;

        while (!q.isEmpty()) {
            int n = q.poll();

            if (n == G) {
                break;
            }

            int u = n + U;
            int d = n - D;

            if (0 < u && u <= F && !isVisit[u]) {
                dp[u] = Math.min(dp[u], dp[n] + 1);
                q.offer(u);
                isVisit[u] = true;
            }

            if (0 < d && d <= F && !isVisit[d]) {
                dp[d] = Math.min(dp[d], dp[n] + 1);
                q.offer(d);
                isVisit[d] = true;
            }
        }

        if (dp[G] == Integer.MAX_VALUE) {
            System.out.println("use the stairs");
        } else {
            System.out.println(dp[G]);
        }
    }
}