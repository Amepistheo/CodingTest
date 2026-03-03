// 1922번 네트워크 연결
package BOJ_1922;

import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Node>> computer = new ArrayList<>();
    private static boolean[] isVisit;

    private static int N, M;
    private static int count, total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            computer.add(new ArrayList<>());
        }

        isVisit = new boolean[N + 1];

        int min = Integer.MAX_VALUE;
        int start = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            computer.get(a).add(new Node(b, c));
            computer.get(b).add(new Node(a, c));

            if (c < min) {
                min = c;
                start = a;
            }
        }

        prim(start);

        System.out.println(total);
    }

    private static void prim(int start) {
        Queue<Node> q = new PriorityQueue<>((o1, o2) -> {return o1.weight - o2.weight;});
        q.offer(new Node(start, 0));

        while (!q.isEmpty()) {
            Node n = q.poll();

            if (isVisit[n.arrive]) {
                continue;
            }
            
            isVisit[n.arrive] = true;
            total += n.weight;
            count++;

            if (count == N) {
                break;
            }

            for (Node node : computer.get(n.arrive)) {
                if (isVisit[node.arrive]) {
                    continue;
                }

                q.offer(node);
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