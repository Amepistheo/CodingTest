// 15650번 N과 M (2)
package BOJ_15650;

import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static boolean[] isVisit;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isVisit = new boolean[N];
        list = new int[M];

        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int depth) {

        if (depth == M) {
            for (int i=0; i<M; i++) {
                sb.append(list[i]).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i=0; i<N; i++) {
            if (isVisit[i])
                continue;

            isVisit[i] = true;
            list[depth] = i+1;

            dfs(depth + 1);

            // 자신보다 큰 수만 고려함
            for (int j=i+1; j<N; j++) {
                isVisit[j] = false;
            }
        }
    }
}