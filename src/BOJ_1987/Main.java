// 1987번 알파벳
package BOJ_1987;

import java.io.*;
import java.util.*;

public class Main {

    private static int[] dR = {-1, 1, 0, 0};
    private static int[] dC = {0, 0, -1, 1};

    private static char[][] board;
    private static boolean[] isVisit;

    private static int R, C;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        isVisit = new boolean[26];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        isVisit[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(max);
    }

    private static void dfs(int x, int y, int count) {
        max = Math.max(max, count);

        for (int i = 0; i < 4; i++) {
            int dr = x + dR[i];
            int dc = y + dC[i];

            if (dr < 0 || dr >= R || dc < 0 || dc >= C) {
                continue;
            }

            char c = board[dr][dc];

            if (isVisit[c - 'A']) {
                continue;
            }

            isVisit[c - 'A'] = true;
            dfs(dr, dc, count + 1);
            isVisit[c - 'A'] = false;
        }
    }
}