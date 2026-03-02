// 2573번 빙산
package BOJ_2573;

import java.io.*;
import java.util.*;

public class Main {

    private static int[] dR = {-1, 1, 0, 0};
    private static int[] dC = {0, 0, -1, 1};

    private static int[][] map;
    private static boolean[][] isVisit;

    private static int N, M;
    private static int count, year = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            isVisit = new boolean[N][M];
            count = 0;

            countIceberg();

            if (count == 0) {
                System.out.println(0);
                break;
            } else if (count > 1) {
                System.out.println(year);
                break;
            } else {
                melt();
                year++;
            }
        }
    }

    private static void countIceberg() {
        for (int i = 0 ; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] <= 0) {
                    continue;
                }

                if (isVisit[i][j]) {
                    continue;
                }

                search(i, j);
                count++;
            }
        }
    }

    private static void search(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (isVisit[node.x][node.y]) {
                continue;
            }

            isVisit[node.x][node.y] = true;

            for (int k = 0; k < 4; k++) {
                int dr = node.x + dR[k];
                int dc = node.y + dC[k];

                if (dr < 0 || dr >= N || dc < 0 || dc >= M) {
                    continue;
                }

                if (map[dr][dc] <= 0) {
                    continue;
                }

                if (isVisit[dr][dc]) {
                    continue;
                }

                q.offer(new Node(dr, dc));
            }
        }
    }

    private static void melt() {
        Queue<Node> q = new LinkedList<>();

        for (int i = 0 ; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    continue;
                }

                q.offer(new Node(i, j));
            }
        }

        while (!q.isEmpty()) {
            Node n = q.poll();

            for (int k = 0; k < 4; k++) {
                int dr = n.x + dR[k];
                int dc = n.y + dC[k];

                if (dr < 0 || dr >= N || dc < 0 || dc >= M) {
                    continue;
                }

                if (map[dr][dc] <= 0) {
                    continue;
                }

                if (map[dr][dc] <= 1) {
                    map[dr][dc] = 0;
                } else {
                    map[dr][dc] -= 1;
                }
            }
        }
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