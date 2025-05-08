// 3055번 탈출
package BOJ_3055;

import java.io.*;
import java.util.*;

public class Main {

    private static int[] dR = {-1, 1, 0, 0};
    private static int[] dC = {0, 0, -1, 1};

    private static int R, C;
    private static int min = Integer.MAX_VALUE;

    private static String[][] map;
    private static boolean[][] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new String[R][C];
        isVisit = new boolean[R][C];

        int x = -1;
        int y = -1;

        for (int i = 0; i < R; i++) {
            String[] str = br.readLine().split("");

            for (int j = 0; j < C; j++) {
                map[i][j] = str[j];

                if (map[i][j].equals("S")) {
                    x = i;
                    y = j;
                }
            }
        }

        bfs(x, y);

        if (min == Integer.MAX_VALUE) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(min);
        }
    }

    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0));
        isVisit[x][y] = true;

        int currentDepth = -1;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (map[node.x][node.y].equals("D")) {
                min = Math.min(min, node.depth);
                continue;
            }

            if (currentDepth < node.depth) {
                currentDepth = node.depth;
                floodMap();
            }

            for (int i = 0; i < 4; i++) {
                int dr = node.x + dR[i];
                int dc = node.y + dC[i];

                if (dr < 0 || dr >= R || dc < 0 || dc >= C) {
                    continue;
                }

                if (isVisit[dr][dc]) {
                    continue;
                }

                if (map[dr][dc].equals("*") || map[dr][dc].equals("X")) {
                    continue;
                }

                q.offer(new Node(dr, dc, node.depth + 1));
                isVisit[dr][dc] = true;
            }
        }
    }

    private static void floodMap() {
        Queue<Node> tq = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j].equals("*")) {
                    tq.offer(new Node(i, j, 0));
                }
            }
        }

        while (!tq.isEmpty()) {
            Node node = tq.poll();

            for (int k = 0; k < 4; k++) {
                int dr = node.x + dR[k];
                int dc = node.y + dC[k];

                if (dr < 0 || dr >= R || dc < 0 || dc >= C) {
                    continue;
                }

                if (!map[dr][dc].equals(".")) {
                    continue;
                }

                map[dr][dc] = "*";
            }
        }
    }
}

class Node {
    int x;
    int y;
    int depth;

    public Node(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}