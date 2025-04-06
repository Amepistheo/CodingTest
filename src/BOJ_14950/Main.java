// 14950번 정복자
package BOJ_14950;

import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Node>> city = new ArrayList<>();
    private static boolean[] isVisit;

    private static int N, M, t, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            city.add(new ArrayList<>());
        }

        isVisit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            city.get(A).add(new Node(B, C));
            city.get(B).add(new Node(A, C));
        }

        prim();

        int charge = t * (((N - 2) * (N - 1)) / 2);
        System.out.println(min + charge);
    }

    private static void prim() {
        Queue<Node> q = new PriorityQueue<>((o1, o2) -> {return o1.weight - o2.weight;});
        q.offer(new Node(1, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (isVisit[node.arrive]) {
                continue;
            }

            isVisit[node.arrive] = true;
            min += node.weight;

            for (Node n : city.get(node.arrive)) {
                if (isVisit[n.arrive]) {
                    continue;
                }

                q.offer(n);
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