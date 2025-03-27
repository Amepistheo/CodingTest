// 11404번 플로이드
package BOJ_11404;

import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Node>> city = new ArrayList<>();

    private static int[][] pay;
    private static int[] dp;
    private static boolean[] isVisit;

    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        pay = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            city.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            city.get(a).add(new Node(b, c));
        }

        for (int i = 1; i <= n; i++) {
            isVisit = new boolean[n + 1];
            dp  = new int[n + 1];

            Arrays.fill(dp, Integer.MAX_VALUE);
            dijkstra(i);

            for (int j = 1; j <= n; j++) {
                if (dp[j] == Integer.MAX_VALUE) {
                    pay[i][j] = 0;
                } else {
                    pay[i][j] = dp[j];
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(pay[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void dijkstra(int depart) {
        Queue<Node> q = new PriorityQueue<>((o1, o2) -> {return o1.weight - o2.weight;});
        q.offer(new Node(depart, 0));
        dp[depart] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (isVisit[node.arrive]) {
                continue;
            }

            isVisit[node.arrive] = true;

            for (Node n : city.get(node.arrive)) {
                if (isVisit[n.arrive]) {
                    continue;
                }

                if (dp[node.arrive] + n.weight < dp[n.arrive]) {
                    dp[n.arrive] = dp[node.arrive] + n.weight;
                    q.offer(new Node(n.arrive, dp[n.arrive]));
                }
            }
        }
    }
}

class Node {
    int arrive;
    int weight;

    public Node(int arrive, int weight) {
        this.arrive = arrive;
        this.weight = weight;
    }
}