// 1916번 최소비용 구하기
package BOJ_1916;

import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int start, end;
    private static List<List<Node>> city = new ArrayList<>();
    private static int[] dist;
    private static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        setting();
        dijkstra();

        System.out.println(dist[end]);
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dist = new int[N + 1];
        isVisit = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            city.add(new ArrayList<>());
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());

            city.get(x).add(new Node(y, pay));
        }

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }

    private static void dijkstra() {
        Queue<Node> q = new PriorityQueue<>((o1, o2) -> {return o1.weight - o2.weight;});
        q.offer(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int start = node.arrive;

            if (isVisit[start]) {
                continue;
            }

            isVisit[start] = true;

            for (int i = 0; i < city.get(start).size(); i++) {
                Node end = city.get(start).get(i);

                if (isVisit[end.arrive]) {
                    continue;
                }

                if (dist[start] + end.weight < dist[end.arrive]) {
                    dist[end.arrive] = dist[start] + end.weight;
                    q.offer(new Node(end.arrive, dist[end.arrive]));
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