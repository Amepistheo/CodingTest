// 18404번 현명한 나이트
package BOJ_18404;

import java.io.*;
import java.util.*;

public class Main {

    private static int[] dR = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static int[] dC = {-1, 1, -2, 2, -2, 2, -1, 1};

    private static int[][] map;
    private static boolean[][] isVisit;

    private static int N, M;
    private static int X, Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        isVisit = new boolean[N + 1][N + 1];

        bfs(X, Y);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(map[A][B]).append(" ");
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0));
        map[x][y] = 0;

        while(!q.isEmpty()) {
            Node n = q.poll();

            if (isVisit[n.x][n.y]) {
                continue;
            }

            isVisit[n.x][n.y] = true;

            for (int i = 0; i < 8; i++) {
                int dr = n.x + dR[i];
                int dc = n.y + dC[i];

                if (dr > N || dr < 1 || dc > N || dc < 1) {
                    continue;
                }

                if (isVisit[dr][dc]) {
                    continue;
                }

                q.offer(new Node(dr, dc, n.count + 1));
                map[dr][dc] = n.count + 1;
            }
        }
    }
}

class Node {
    int x;
    int y;
    int count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}