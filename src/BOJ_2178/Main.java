// 2178번 미로 탐색
package BOJ_2178;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};

    static int[][] map;
    static boolean[][] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());               // 행의 개수
        int M = Integer.parseInt(st.nextToken());               // 열의 개수

        map = new int[N][M];
        isVisit = new boolean[N][M];

        for (int i=0; i<N; i++) {
            String input = br.readLine();
            for (int j=0; j<M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        bfs(N, M);

        System.out.println(map[N-1][M-1]);
    }

    // bfs 탐색을 통해 1이 있는 부분을 거치는 경우 부모 노드에 1을 더한 값을 저장
    public static void bfs(int N, int M) {
        Queue<Node> q = new LinkedList<>();
        int count=0;

        q.offer(new Node(0, 0));
        isVisit[0][0] = true;

        while(!q.isEmpty()) {
            Node vertex = q.poll();

            for (int i=0; i<4; i++) {
                int dr = vertex.row + dR[i];
                int dc = vertex.col + dC[i];

                if (dr<0 || dr>=N || dc<0 || dc>=M)
                    continue;
                if (map[dr][dc] == 0)
                    continue;
                if (isVisit[dr][dc])
                    continue;

                q.offer(new Node(dr, dc));
                map[dr][dc] = map[vertex.row][vertex.col] + 1;
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
