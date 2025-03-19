// 1753번 최단경로
package BOJ_1753;

import java.io.*;
import java.util.*;

public class Main {

    private static int V, E, K;
    private static List<List<Node>> route = new ArrayList<>();
    private static int[] minRoute;
    private static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        minRoute = new int[V + 1];
        Arrays.fill(minRoute, Integer.MAX_VALUE);
        minRoute[K] = 0;

        for (int i = 0; i <= V; i++) {
            route.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            route.get(u).add(new Node(v, w));
        }

        dijkstra();

        for (int i = 1; i <= V; i++) {
            if (minRoute[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(minRoute[i]).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static void dijkstra() {
        isVisit = new boolean[V + 1];

        Queue<Node> q = new PriorityQueue<>((o1, o2) -> {return o1.weight - o2.weight;});
        q.offer(new Node(K, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (isVisit[node.dest]) {
                continue;
            }

            isVisit[node.dest] = true;

            for (Node n : route.get(node.dest)) {
                if (isVisit[n.dest]) {
                    continue;
                }

                if (n.weight + minRoute[node.dest] < minRoute[n.dest]) {
                    minRoute[n.dest] = n.weight + minRoute[node.dest];
                    q.offer(new Node(n.dest, minRoute[n.dest]));
                }
            }
        }
    }
}

class Node {
    int dest;
    int weight;

    public Node(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}