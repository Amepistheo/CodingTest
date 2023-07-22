// 4963번 섬의 개수
package BOJ_4963;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dR = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dC = {-1, -1, -1, 0, 0, 1, 1, 1};

    static int[][] map;
    static boolean[][] isVisit;
    static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());               // 지도의 너비(열)
            h = Integer.parseInt(st.nextToken());               // 지도의 높이(행)

            if(w == 0 && h == 0)
                break;

            map = new int[h][w];
            isVisit = new boolean[h][w];

            // 지도에 입력값 넣기
            for (int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append(search()).append('\n');
        }

        System.out.print(sb);
    }

    // 섬이 있는 위치 찾는 함수
    public static int search() {
        int count = 0;

        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                if (map[i][j] == 0)
                    continue;
                if (isVisit[i][j])
                    continue;

                bfs(i, j);
                count++;
            }
        }

        return count;
    }

    // 주변에 섬이 있는지 탐색
    public static void bfs(int row, int col) {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(row, col));
        isVisit[row][col] = true;

        while(!q.isEmpty()) {
            Node vertex = q.poll();

            for (int i=0; i<8; i++) {
                int dr = vertex.row + dR[i];
                int dc = vertex.col + dC[i];

                if (dr<0 || dr>=h || dc<0 || dc>=w)
                    continue;
                if (map[dr][dc] == 0)
                    continue;
                if (isVisit[dr][dc])
                    continue;

                q.offer(new Node(dr, dc));
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
