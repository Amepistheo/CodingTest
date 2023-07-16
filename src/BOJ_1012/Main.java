// 1012번 유기농 배추
package BOJ_1012;

import java.io.*;
import java.util.*;

public class Main {
    static int[] dR = {1, -1, 0, 0};                        // 상하 탐색
    static int[] dC = {0, 0, 1, -1};                        // 좌우 탐색
    static int M, N, K;
    static boolean[][] bachuMap;
    static boolean[][] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());            // 테스트 케이스의 개수

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());           // 행의 개수
            N = Integer.parseInt(st.nextToken());           // 열의 개수
            K = Integer.parseInt(st.nextToken());           // 배추가 심어진 위치의 개수

            bachuMap = new boolean[M][N];
            isVisit = new boolean[M][N];

            // 배추가 심어진 곳 true로 변경
            while(K-- > 0) {
                st = new StringTokenizer(br.readLine());

                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());

                bachuMap[row][col] = true;
            }

            sb.append(searchMap()).append('\n');
        }

        System.out.print(sb);
    }

    // 배추가 심어진 위치 찾는 함수
    public static int searchMap() {
        int count = 0;

        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                // 배추가 없는 경우
                if (!bachuMap[i][j])
                    continue;
                // 이미 방문한 곳인 경우
                if (isVisit[i][j])
                    continue;

                // 모든 조건문에 해당되지 않은 경우 bfs 함수로 넘어감
                bfs(i, j);
                count++;
            }
        }

        return count;
    }

    // 배추가 심어진 위치에서 인접한 배추 탐색
    public static void bfs(int row, int col) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(row, col));
        isVisit[row][col] = true;

        while(!q.isEmpty()) {
            Node vertex = q.poll();

            for (int i=0; i<4; i++) {
                int dr = vertex.row + dR[i];
                int dc = vertex.col + dC[i];

                // 상하좌우 탐색 시 범위를 벗어난 경우
                if (dr<0 || dr>=M || dc<0 || dc>=N)
                    continue;
                // 배추가 없는 경우
                if (!bachuMap[dr][dc])
                    continue;
                // 이미 탐색한 곳인 경우
                if (isVisit[dr][dc])
                    continue;

                q.offer(new Node(dr, dc));
                isVisit[dr][dc] = true;
            }
        }
    }
}

class Node {
    int row;
    int col;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}