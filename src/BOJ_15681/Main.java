// 15681번 트리와 쿼리
package BOJ_15681;

import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Integer>> tree = new ArrayList<>();
    private static boolean[] isVisit;
    private static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        isVisit = new boolean[N + 1];
        count = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            tree.get(U).add(V);
            tree.get(V).add(U);
        }

        Arrays.fill(count, 1);

        dfs(R);

        for (int i = 0; i < Q; i++) {
            int root = Integer.parseInt(br.readLine());
            sb.append(count[root]).append("\n");
        }

        System.out.print(sb);
    }

    private static void dfs(int node) {
        isVisit[node] = true;

        if (tree.get(node).isEmpty()) {
            return;
        }

        for (int num : tree.get(node)) {
            if (isVisit[num]) {
                continue;
            }

            dfs(num);

            count[node] += count[num];
        }
    }
}