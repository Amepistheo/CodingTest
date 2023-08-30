// 14940번 쉬운 최단거리
package BOJ_14940;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};

    static int[][] map;
    static int[][] count;
    static boolean[][] isVisit;

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());           // 세로의 크기
        m = Integer.parseInt(st.nextToken());           // 가로의 크기
        int row = -1;
        int col = -1;

        map = new int[n][m];
        count = new int[n][m];
        isVisit = new boolean[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    row = i;
                    col = j;
                }
            }
        }

        bfs(row, col);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisit[i][j] && map[i][j] == 1)
                    sb.append(-1).append(" ");
                else
                    sb.append(count[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void bfs(int startRow, int startCol) {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(startRow, startCol));
        isVisit[startRow][startCol] = true;

        while(!q.isEmpty()) {
            Node vertex = q.poll();

            for (int i = 0; i < 4; i++) {
                int dr = vertex.row + dR[i];
                int dc = vertex.col + dC[i];

                if (dr < 0 || dr >= n || dc < 0 || dc >= m)
                    continue;
                if (map[dr][dc] == 0)
                    continue;
                if (isVisit[dr][dc])
                    continue;

                q.offer(new Node(dr, dc));
                count[dr][dc] = count[vertex.row][vertex.col] + 1;
                isVisit[dr][dc] = true;
            }
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