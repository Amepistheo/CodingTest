// 2583번 영역 구하기
package BOJ_2583;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};

    static boolean[][] map;
    static List<Integer> l = new LinkedList<>();

    static int M, N;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    map[j][k] = true;
                }
            }
        }

        search();

        Collections.sort(l);

        sb.append(count).append("\n");

        for (int i = 0; i < l.size(); i++) {
            sb.append(l.get(i)).append(" ");
        }

        System.out.print(sb);
    }

    private static void search() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!map[i][j]) {
                    l.add(bfs(i, j));
                    count++;
                }
            }
        }
    }

    private static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(x, y));
        map[x][y] = true;
        int total = 1;

        while (!q.isEmpty()) {
            Node vertex = q.poll();

            for (int i = 0; i < 4; i++) {
                int dr = vertex.x + dR[i];
                int dc = vertex.y + dC[i];

                if (dr < 0 || dr >= M || dc < 0 || dc >= N) {
                    continue;
                }
                if (map[dr][dc]) {
                    continue;
                }

                q.offer(new Node(dr, dc));
                map[dr][dc] = true;

                total++;
            }
        }

        return total;
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