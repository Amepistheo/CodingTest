// 1197번 최소 스패닝 트리
package BOJ_1197;

import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Node>> graph = new ArrayList<>();
    private static boolean[] isVisit;

    private static int V, E;
    private static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        isVisit = new boolean[V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int A =  Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Node(B, C));
            graph.get(B).add(new Node(A, C));
        }

        prim(1);

        System.out.println(min);
    }

    private static void prim(int start) {
        Queue<Node> q = new PriorityQueue<>((o1, o2) -> {return o1.weight - o2.weight;});
        q.offer(new Node(start, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (isVisit[node.vertex]) {
                continue;
            }

            isVisit[node.vertex] = true;
            min += node.weight;

            for (Node n : graph.get(node.vertex)) {
                if (isVisit[n.vertex]) {
                    continue;
                }

                q.offer(n);
            }
        }
    }
}

class Node {
    int vertex;
    int weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}