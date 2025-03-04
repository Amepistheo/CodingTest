// 1068번 트리
package BOJ_1068;

import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Integer>> tree = new ArrayList<>();
    private static boolean[] isRemoved;
    private static int count = 0;
    private static int remove = 0;

    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int root = 0;

        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }

        isRemoved = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int node = Integer.parseInt(st.nextToken());

            if (node == -1) {
                root = i;
                continue;
            }

            tree.get(node).add(i);
        }

        remove = Integer.parseInt(br.readLine());

        if (remove != root) {
            isRemoved[remove] = true;
            dfs(root);
        }

        System.out.println(count);
    }

    private static void dfs(int node) {
        if (isRemoved[node]) {
            return;
        }

        if (tree.get(node).isEmpty()) {
            count++;
            return;
        }

        int childCount = 0;

        for (int child : tree.get(node)) {
            dfs(child);

            if (!isRemoved[child]) {
                childCount++;
            }
        }

        if (childCount == 0) {
            count++;
        }
    }
}