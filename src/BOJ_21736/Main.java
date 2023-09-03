// 21736번 헌내기는 친구가 필요해
package BOJ_21736;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};

    static int N, M;

    static String[][] map;
    static boolean[][] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        isVisit = new boolean[N][M];

        int row = -1;
        int col = -1;

        // O:빈 공간, X:벽, I:도연, P:사람
        for (int i=0; i<N; i++) {
            String input = br.readLine();

            for (int j=0; j<M; j++) {
                map[i][j] = String.valueOf(input.charAt(j));

                if (map[i][j].equals("I")) {
                    row = i;
                    col = j;
                }
            }
        }

        int result = bfs(row, col);

        if (result == 0)
            System.out.println("TT");
        else
            System.out.println(result);

    }

    public static int bfs(int startRow, int startCol) {
        Queue<Node> q = new LinkedList<>();

        int count = 0;

        q.offer(new Node(startRow, startCol));
        isVisit[startRow][startCol] = true;

        while(!q.isEmpty()) {
            Node vertex = q.poll();

            for (int i=0; i<4; i++) {
                int dr = vertex.row + dR[i];
                int dc = vertex.col + dC[i];

                if (dr<0 || dr>=N || dc<0 || dc>=M)
                    continue;
                if (map[dr][dc].equals("X"))
                    continue;
                if (isVisit[dr][dc])
                    continue;

                if (map[dr][dc].equals("P"))
                    count++;

                q.offer(new Node(dr, dc));
                isVisit[dr][dc] = true;
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