// 3187번 양치기 꿍
package BOJ_3187;

import java.io.*;
import java.util.*;

public class Main {

    private static int R, C;
    private static int v, k;

    private static int[] dR = {-1, 1, 0, 0};
    private static int[] dC = {0, 0, -1, 1};

    private static char[][] map;
    private static boolean[][] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        isVisit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();

            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        search();

        sb.append(k).append(" ").append(v);

        System.out.println(sb);
    }

    private static void search() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (isVisit[i][j]) {
                    continue;
                }
                if (map[i][j] != '#') {
                    bfs(i, j);
                }
            }
        }
    }

    private static void bfs(int row, int col) {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(row, col));
        isVisit[row][col] = true;

        int wolf = 0;
        int sheep = 0;

        while (!q.isEmpty()) {
            Node vertex = q.poll();

            if (map[vertex.row][vertex.col] == 'v') {
                wolf++;
            }
            else if (map[vertex.row][vertex.col] == 'k') {
                sheep++;
            }

            for (int i = 0; i < 4; i++) {
                int dr = vertex.row + dR[i];
                int dc = vertex.col + dC[i];

                if (dr < 0 || dr >= R || dc < 0 || dc >= C) {
                    continue;
                }
                if (isVisit[dr][dc]) {
                    continue;
                }
                if (map[dr][dc] == '#') {
                    continue;
                }

                q.offer(new Node(dr, dc));
                isVisit[dr][dc] = true;
            }
        }

        if (sheep > wolf) {
            k += sheep;
        }
        else {
            v += wolf;
        }
    }
}

class Node {
    int row, col;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}