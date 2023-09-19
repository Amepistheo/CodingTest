// 15649번 N과 M (1)
package BOJ_15649;

import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int N, M;

    static boolean[] isVisit;
    static int[] map;

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

    public static void dfs(int depth) {
        if (depth == M) {
            for (int i=0; i<M; i++) {
                sb.append(map[i]).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i=0; i<N; i++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                map[depth] = i+1;
                // 다음 자식 노드 방문을 위해 depth+1 하고서 재귀 호출
                dfs(depth + 1);
                // 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
                isVisit[i] = false;
            }
        }
    }
}