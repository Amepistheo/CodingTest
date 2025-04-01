// 1647번 도시 분할 계획
package BOJ_1647;

import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Node>> village = new ArrayList<>();
    private static boolean[] isVisit;

    private static int N, M;
    private static int min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            village.add(new ArrayList<>());
        }

        isVisit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            village.get(A).add(new Node(B, C));
            village.get(B).add(new Node(A, C));
        }

        prim();

        System.out.println(min - max);
    }

    private static void prim() {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        q.offer(new Node(1, 0));

        int count = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (isVisit[node.home]) {
                continue;
            }

            isVisit[node.home] = true;
            min += node.weight;

            if (node.weight > 0) {
                max = Math.max(max, node.weight);
                count++;
            }

            if (count == N) {
                break;
            }

            for (Node n : village.get(node.home)) {
                if (isVisit[n.home]) {
                    continue;
                }

                q.offer(n);
            }
        }
    }
}

class Node {
    int home;
    int weight;

    public Node(int home, int weight) {
        this.home = home;
        this.weight = weight;
    }
}