// 16562번 친구비
package BOJ_16562;

import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Integer>> graph = new ArrayList<>();
    private static Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.fee));

    private static int[] friendFee;
    private static boolean[] isVisit;

    private static int minFee;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        isVisit = new boolean[N + 1];
        friendFee = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            friendFee[i] = Integer.parseInt(st.nextToken());
            pq.offer(new Node(i, friendFee[i]));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(v).add(w);
            graph.get(w).add(v);
        }

        solve();

        if (k < minFee) {
            System.out.println("Oh no");
        } else {
            System.out.println(minFee);
        }
    }

    private static void solve() {
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (isVisit[node.num])  {
                continue;
            }

            isVisit[node.num] = true;
            minFee += node.fee;

            Queue<Integer> q = new LinkedList<>();
            q.offer(node.num);

            while (!q.isEmpty()) {
                int friend = q.poll();

                for (int next : graph.get(friend)) {
                    if (isVisit[next]) {
                        continue;
                    }

                    isVisit[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}

class Node {
    int num;
    int fee;

    public Node(int num, int fee) {
        this.num = num;
        this.fee = fee;
    }
}