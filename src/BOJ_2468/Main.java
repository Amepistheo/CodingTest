// 2468번 안전 영역
package BOJ_2468;

import java.io.*;
import java.util.*;

public class Main {
    static int[] dR = {1, -1, 0, 0};                    // 상하 탐색
    static int[] dC = {0, 0, 1, -1};                    // 좌우 탐색

    static int N;
    static int[][] safeMap;
    static boolean[][] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());            // 행과 열의 개수
        safeMap = new int[N][N];                        // 행렬 초기화

        int max = Integer.MIN_VALUE;                    // 최대값 초기화
        int min = Integer.MAX_VALUE;                    // 최소값 초기화

        // safeMap에 입력값 넣기
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<N; j++) {
                safeMap[i][j] = Integer.parseInt(st.nextToken());

                min = Math.min(min, safeMap[i][j]);     // 최소값 갱신
                max = Math.max(max, safeMap[i][j]);     // 최대값 갱신
            }
        }

        int maxCount = 0;

        if (min == max)                                 // 최소값과 최대값이 같은 경우 무조건 안전영역이 1인 경우가 있음
            maxCount = 1;
        else {                                          // 최소값부터 최대값까지 비교하여 최대값인 count 출력
            for (int h=min; h<max; h++) {
                maxCount = Math.max(maxCount, search(h));
            }
        }

        System.out.println(maxCount);
    }

    // 안전영역인 경우 탐색
    // min ~ max까지 탐색하기 때문에 search() 호출할 때마다 isVisit 초기화해줘야함!!
    public static int search(int h) {
        int count = 0;
        isVisit = new boolean[N][N];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (safeMap[i][j] <= h)
                    continue;
                if (isVisit[i][j])
                    continue;

                bfs(i, j, h);
                count++;
            }
        }

        return count;
    }
    public static void bfs(int row, int col, int h) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(row, col));
        isVisit[row][col] = true;

        while(!q.isEmpty()) {
            Node vertex = q.poll();

            for (int i=0; i<4; i++) {
                int dr = vertex.row + dR[i];
                int dc = vertex.col + dC[i];

                if (dr<0 || dr>=N || dc<0 || dc>=N)
                    continue;
                if (safeMap[dr][dc] <= h)
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