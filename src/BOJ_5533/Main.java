// 5533번 유니크
package BOJ_5533;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] player = new int[N][3];
        int[][] game = new int[3][101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                int score = Integer.parseInt(st.nextToken());

                player[i][j] = score;
                game[j][score]++;
            }
        }

        for (int i = 0; i < N; i++) {
            int count = 0;

            for (int j = 0; j < 3; j++) {
                if (game[j][player[i][j]] == 1) {
                    count += player[i][j];
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
