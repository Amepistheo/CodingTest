// 1967번 트리의 지름
package BOJ_1967;

import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Node>> tree = new ArrayList<>();
    private static boolean[] isVisit;

    private static int n;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

         n = Integer.parseInt(br.readLine());

         for (int i = 0; i <= n; i++) {
             tree.add(new ArrayList<>());
         }

         boolean[] leaf = new boolean[n + 1];
         Arrays.fill(leaf, true);

         for (int i = 0; i < n - 1; i++) {
             st = new StringTokenizer(br.readLine());

             int parent = Integer.parseInt(st.nextToken());
             int child = Integer.parseInt(st.nextToken());
             int weight = Integer.parseInt(st.nextToken());

             tree.get(parent).add(new Node(child, weight));
             tree.get(child).add(new Node(parent, weight));

             leaf[parent] = false;
         }

         for (int i = 1; i <= n; i++) {
             if (!leaf[i]) {
                 continue;
             }

             isVisit = new boolean[n + 1];
             dfs(i, 0);
         }

        System.out.println(max);
    }

    private static void dfs(int node, int sum) {
        isVisit[node] = true;
        max = Math.max(max, sum);

        for (Node n : tree.get(node)) {
            if (isVisit[n.child]) {
                continue;
            }

            dfs(n.child, n.weight + sum);
        }
    }
}

class Node {
    int child;
    int weight;

    public Node(int child, int weight) {
        this.child = child;
        this.weight = weight;
    }
}