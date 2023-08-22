// 2667번 단지번호붙이기
package BOJ_2667;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};

    static boolean[][] map;
    static boolean[][] isVisit;

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new PriorityQueue<>();

        N = Integer.parseInt(br.readLine());

        map = new boolean[N][N];
        isVisit = new boolean[N][N];

        for (int i=0; i<N; i++) {
            String input = br.readLine();

            for (int j=0; j<N; j++) {
                if (input.charAt(j) == '0')
                    map[i][j] = false;
                else
                    map[i][j] = true;
            }
        }

        int apart = 0;

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!map[i][j])
                    continue;
                if (isVisit[i][j])
                    continue;

                q.offer(bfs(i, j));
                apart++;
            }
        }

        sb.append(apart).append("\n");

        while(!q.isEmpty()) {
            sb.append(q.poll()).append("\n");
        }

        System.out.print(sb);
    }

    public static int bfs(int row, int col) {
        Queue<Node> q = new LinkedList<>();
        int count = 1;

        q.offer(new Node(row, col));
        isVisit[row][col] = true;

        while(!q.isEmpty()) {
            Node vertex = q.poll();

            for (int i=0; i<4; i++) {
                int dr = vertex.row + dR[i];
                int dc = vertex.col + dC[i];

                if (dr<0 || dr>=N || dc<0 || dc>=N)
                    continue;
                if (!map[dr][dc])
                    continue;
                if (isVisit[dr][dc])
                    continue;

                q.offer(new Node(dr, dc));
                isVisit[dr][dc] = true;
                count++;
            }
        }

        return count;
    }
}

class Node {
    int row, col;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}