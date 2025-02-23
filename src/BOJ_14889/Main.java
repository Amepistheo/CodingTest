// 14889번 스타트와 링크
package BOJ_14889;

import java.io.*;
import java.util.*;

public class Main {

    private static int[][] ability;
    private static boolean[] isStart;

    private static int N;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        ability = new int[N + 1][N + 1];
        isStart = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        back(1, 0);

        System.out.println(min);
    }

    private static void back(int num, int count) {
        if (count == N / 2) {
            int start = 0;
            int link = 0;

            for (int i = 1; i < N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    if (isStart[i] && isStart[j]) {
                        start += (ability[i][j] + ability[j][i]);
                    } else if (!isStart[i] && !isStart[j]) {
                        link += (ability[i][j] + ability[j][i]);
                    }
                }
            }

            min = Math.min(min, Math.abs(start - link));
            return;
        }

        for (int i = num; i <= N; i++) {
            if (!isStart[i]) {
                isStart[i] = true;
                back(i + 1, count + 1);
                isStart[i] = false;
            }
        }
    }
}