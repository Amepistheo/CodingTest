// 7569번 토마토
package BOJ_7569;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dR = {0, 0, -1, 1, 0, 0};
    static int[] dC = {1, -1, 0, 0, 0, 0};
    static int[] dH = {0, 0, 0, 0, 1, -1};

    static int M, N, H;

    static int[][][] storage;

    static Queue<Node> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());           // 열
        N = Integer.parseInt(st.nextToken());           // 행
        H = Integer.parseInt(st.nextToken());           // 높이

        storage = new int[N][M][H];

        for (int i=0; i<H; i++) {
            for (int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k=0; k<M; k++) {
                    storage[j][k][i] = Integer.parseInt(st.nextToken());

                    if (storage[j][k][i] == 1)
                        q.offer(new Node(j, k, i));
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {

        while (!q.isEmpty()) {
            Node vertex = q.poll();

            for (int i=0; i<6; i++) {
                int dr = vertex.row + dR[i];
                int dc = vertex.col + dC[i];
                int dh = vertex.height + dH[i];

                if (dr<0 || dr>=N || dc<0 || dc>=M || dh<0 || dh>=H)
                    continue;
                if (storage[dr][dc][dh] != 0)
                    continue;

                storage[dr][dc][dh] = storage[vertex.row][vertex.col][vertex.height] + 1;
                q.offer(new Node(dr, dc, dh));
            }
        }

        int count = 0;

        for (int i=0; i<H; i++) {
            for (int j=0; j<N; j++) {
                for (int k=0; k<M; k++) {
                    if (storage[j][k][i] == 0)
                        return -1;

                    count = Math.max(count, storage[j][k][i]);
                }
            }
        }

        if (count == 1)
            return 0;
        else
            return (count-1);
    }
}

class Node {
    int row, col, height;

    public Node (int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }
}