// 7576번 토마토
package BOJ_7576;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};

    static int N, M;

    static int[][] storage;

    static Queue<Node> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());           // 열
        N = Integer.parseInt(st.nextToken());           // 행

        storage = new int[N][M];

        // 토마토 정보 입력
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<M; j++) {
                storage[i][j] = Integer.parseInt(st.nextToken());

                // 익은 토마토(1)가 있는 곳을 큐에 넣음
                if (storage[i][j] == 1)
                    q.offer(new Node(i, j));
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {

        while (!q.isEmpty()) {
            Node vertex = q.poll();

            for (int i=0; i<4; i++) {
                int dr = vertex.row + dR[i];
                int dc = vertex.col + dC[i];

                if (dr<0 || dr>=N || dc<0 || dc>=M)
                    continue;
                if (storage[dr][dc] != 0)
                    continue;

                storage[dr][dc] = storage[vertex.row][vertex.col] + 1;
                q.offer(new Node(dr, dc));
            }
        }

        int count = 0;

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (storage[i][j] == 0)
                    return -1;

                count = Math.max(count, storage[i][j]);
            }
        }

        // 저장될 때부터 모든 토마토가 익은 상태면 0 출력
        if (count == 1)
            return 0;
        else
            return (count-1);
    }
}

class Node {
    int row, col;

    Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}