// 15651번 N과 M (3)
package BOJ_15651;

import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    private static int N, M;

    private static boolean[] isVisit;
    private static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isVisit = new boolean[N];
        map = new int[M];

        dfs(0);

        System.out.print(sb);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int i=0; i<M; i++) {
                sb.append(map[i]).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i=0; i<N; i++) {
            isVisit[i] = true;
            map[depth] = i+1;
            dfs(depth + 1);

            isVisit[i] = false;
        }
    }
}