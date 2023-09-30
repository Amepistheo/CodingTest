// 10026번 적록색약
package BOJ_10026;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};

    static int N;

    static char[][] map1;
    static char[][] map2;
    static boolean[][] isVisit1;
    static boolean[][] isVisit2;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map1 = new char[N][N];
        map2 = new char[N][N];
        isVisit1 = new boolean[N][N];
        isVisit2 = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j=0; j<N; j++) {
                map1[i][j] = input.charAt(j);
                map2[i][j] = input.charAt(j);

                if (map2[i][j] == 'G')
                    map2[i][j] = 'R';
            }
        }

        search();

        System.out.println(sb);
    }

    static void search() {
        sb = new StringBuilder();

        int count1 = 0;
        int count2 = 0;

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!isVisit1[i][j]) {
                    bfs1(i, j);
                    count1++;
                }

                if (!isVisit2[i][j]) {
                    bfs2(i, j);
                    count2++;
                }
            }
        }

        sb.append(count1).append(" ").append(count2);
    }

    static void bfs1(int row, int col) {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(row, col));
        isVisit1[row][col] = true;

        while (!q.isEmpty()) {
            Node vertex = q.poll();

            for (int i=0; i<4; i++) {
                int dr = vertex.x + dR[i];
                int dc = vertex.y + dC[i];

                if (dr<0 || dr>=N || dc<0 || dc>=N)
                    continue;
                if (map1[dr][dc] != map1[vertex.x][vertex.y])
                    continue;
                if (isVisit1[dr][dc])
                    continue;

                q.offer(new Node(dr, dc));
                isVisit1[dr][dc] = true;
            }
        }
    }

    static void bfs2(int row, int col) {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(row, col));
        isVisit1[row][col] = true;

        while (!q.isEmpty()) {
            Node vertex = q.poll();

            for (int i=0; i<4; i++) {
                int dr = vertex.x + dR[i];
                int dc = vertex.y + dC[i];

                if (dr<0 || dr>=N || dc<0 || dc>=N)
                    continue;
                if (map2[dr][dc] != map2[vertex.x][vertex.y])
                    continue;
                if (isVisit2[dr][dc])
                    continue;

                q.offer(new Node(dr, dc));
                isVisit2[dr][dc] = true;
            }
        }
    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}