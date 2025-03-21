// 1238번 파티
package BOJ_1238;

import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Node>> road = new ArrayList<>();
    private static int[] way1;
    private static int[] way2;
    private static boolean[] isVisit;

    private static int N, M, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            road.add(new ArrayList<>());
        }

        way1 = new int[N + 1];
        way2 = new int[N + 1];

        Arrays.fill(way1, Integer.MAX_VALUE);
        Arrays.fill(way2, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            road.get(start).add(new Node(end, time));
        }

        for (int i = 1; i <= N; i++) {
            if (i == X) {
                continue;
            }

            goParty(i);
        }

        goHome();

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            if (i == X) {
                continue;
            }

            max = Math.max(max, way1[i] + way2[i]);
        }

        System.out.println(max);
    }

    private static void goParty(int start) {
        isVisit = new boolean[N + 1];
        int[] tempWay = new int[N + 1];
        Arrays.fill(tempWay, Integer.MAX_VALUE);

        Queue<Node> q = new PriorityQueue<>((o1, o2) -> {return o1.weight - o2.weight;});
        q.offer(new Node(start, 0));
        tempWay[start] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.arrive == X) {
                break;
            }

            if (isVisit[node.arrive]) {
                continue;
            }

            isVisit[node.arrive] = true;

            for (Node n : road.get(node.arrive)) {
                if (isVisit[n.arrive]) {
                    continue;
                }

                if (tempWay[node.arrive] + n.weight < tempWay[n.arrive]) {
                    tempWay[n.arrive] = tempWay[node.arrive] + n.weight;
                    q.offer(new Node(n.arrive, tempWay[n.arrive]));
                }
            }
        }

        way1[start] = tempWay[X];
    }

    private static void goHome() {
        isVisit = new boolean[N + 1];

        Queue<Node> q = new PriorityQueue<>((o1, o2) -> {return o1.weight - o2.weight;});
        q.offer(new Node(X, 0));
        way2[X] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (isVisit[node.arrive]) {
                continue;
            }

            isVisit[node.arrive] = true;

            for (Node n : road.get(node.arrive)) {
                if (isVisit[n.arrive]) {
                    continue;
                }

                if (way2[node.arrive] + n.weight < way2[n.arrive]) {
                    way2[n.arrive] = way2[node.arrive] + n.weight;
                    q.offer(new Node(n.arrive, way2[n.arrive]));
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