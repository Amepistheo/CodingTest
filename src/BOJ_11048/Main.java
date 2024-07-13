// 11048번 이동하기
package BOJ_11048;

import java.io.*;
import java.util.*;

public class Main {

    private static int[][] map = new int[1001][1001];
    private static int N, M;

    public static void main(String[] args) throws IOException {
        firstSetting();
        solveProblem();
    }

    private static void firstSetting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void solveProblem() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map[i][j] += Math.max(map[i-1][j-1], Math.max(map[i-1][j], map[i][j-1]));
            }
        }

        System.out.println(map[N][M]);
    }
}