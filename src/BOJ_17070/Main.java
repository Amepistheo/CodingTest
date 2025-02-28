// 17070번 파이프 옮기기1
package BOJ_17070;

import java.io.*;
import java.util.*;

public class Main {

    private static int[] dR = {0, 1, 1};
    private static int[] dC = {1, 0, 1};

    private static int[][] map;

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 1, 0));

        if (map[N - 1][N - 1] == 1) {
            return 0;
        }

        int count = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 3; i++) {
                int dr = node.x + dR[i];
                int dc = node.y + dC[i];
                int shape = node.shape;

                if (dr < 0 || dr >= N || dc < 0 || dc >= N) {
                    continue;
                }

                if (map[dr][dc] == 1) {
                    continue;
                }

                if (shape == 0 && i == 1) {
                    continue;
                } else if (shape == 1 && i == 0) {
                    continue;
                }

                if (i == 2) {
                    if (map[dr - 1][dc] == 1 || map[dr][dc - 1] == 1) {
                        continue;
                    }
                }

                if (dr == (N - 1) && dc == (N - 1)) {
                    count++;
                    continue;
                }

                q.offer(new Node(dr, dc, i));
            }
        }

        return count;
    }
}

class Node {
    int x;
    int y;
    int shape;

    public Node(int x, int y, int shape) {
        this.x = x;
        this.y = y;
        this.shape = shape;
    }
}