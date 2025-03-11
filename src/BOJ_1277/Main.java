// 1277번 발전소 설치
package BOJ_1277;

import java.io.*;
import java.util.*;

public class Main {

    private static Node[] station;
    private static boolean[][] isConnect;

    private static int N, W;
    private static double M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        M = Double.parseDouble(br.readLine());

        station = new Node[N + 1];
        isConnect = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            station[i] = new Node(x, y);
        }

        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());

            int point1 = Integer.parseInt(st.nextToken());
            int point2 = Integer.parseInt(st.nextToken());

            isConnect[point1][point2] = true;
            isConnect[point2][point1] = true;
        }

        System.out.println(dijkstra());
    }

    private static long dijkstra() {
        double[] distance = new double[N + 1];

        for (int i = 1; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[1] = 0;

        for (int i = 2; i <= N; i++) {
            if (isConnect[1][i]) {
                distance[i] = 0;
            }
        }

        boolean[] isVisit = new boolean[N + 1];

        for (int i = 0; i < N; i++) {
            double min = Integer.MAX_VALUE;
            int position = 0;

            for (int j = 1; j <= N; j++) {
                if (!isVisit[j] && (distance[j] <= min)) {
                    min = distance[j];
                    position = j;
                }
            }

            if (position == N) {
                break;
            }

            isVisit[position] = true;

            for (int j = 1; j <= N; j++) {
                if (j == position) {
                    continue;
                }

                if (distance[position] + getDistance(position, j) < distance[j]) {
                    distance[j] = distance[position] + getDistance(position, j);
                }
            }
        }

        return (long) (distance[N] * 1000);
    }

    private static double getDistance(int position, int next) {
        if (isConnect[position][next]) {
            return 0;
        }

        Node station1 = station[position];
        Node station2 = station[next];

        double distance = Math.pow(station1.x - station2.x, 2) + Math.pow(station1.y - station2.y, 2);

        return Math.sqrt(distance);
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}