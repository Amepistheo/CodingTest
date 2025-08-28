// 16398번 행성 연결
package BOJ_16398;

import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Node>> graph = new ArrayList<>();
    private static boolean[] isVisit;

    private static int N;
    private static int minNode;
    private static long count, total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        isVisit = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        int minWeight = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int w = Integer.parseInt(st.nextToken());

                if (i <= j) {
                    continue;
                }

                graph.get(i).add(new Node(j, w));
                graph.get(j).add(new Node(i, w));

                if (w < minWeight) {
                    minWeight = w;
                    minNode = i;
                }
            }
        }

        prim();

        System.out.println(total);
    }

    private static void prim() {
        Queue<Node> q = new PriorityQueue<>((o1, o2) -> {return o1.weight - o2.weight;});
        q.offer(new Node(minNode, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (isVisit[node.vertex]) {
                continue;
            }

            isVisit[node.vertex] = true;
            total += node.weight;
            count++;

            if (count == N) {
                break;
            }

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