// 1743번 음식물 피하기
package BOJ_1743;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};

    static boolean[][] map;
    static boolean[][] isVisit;

    static int N, M;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new boolean[N + 1][M + 1];
        isVisit = new boolean[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = true;
        }

        search();

        System.out.println(max);
    }

    private static void search() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (isVisit[i][j]) {
                    continue;
                }

                if (!map[i][j]) {
                    continue;
                }

                bfs(i, j);
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        isVisit[x][y] = true;

        int count = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int dr = node.x + dR[i];
                int dc = node.y + dC[i];

                if (dr <= 0 || dr > N || dc <= 0 || dc > M) {
                    continue;
                }

                if (isVisit[dr][dc]) {
                    continue;
                }

                if (!map[dr][dc]) {
                    continue;
                }

                q.offer(new Node(dr, dc));
                isVisit[dr][dc] = true;
                count++;
            }
        }

        max = Math.max(max, count);
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