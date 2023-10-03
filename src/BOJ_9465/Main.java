// 9465번 스티커
package BOJ_9465;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());

            int[][] map = new int[2][n+1];
            int[][] sticker = new int[2][n+1];

            for (int j=0; j<2; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k=1; k<=n; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            sticker[0][1] = map[0][1];
            sticker[1][1] = map[1][1];

            for (int j=2; j<=n; j++) {
                sticker[0][j] = Math.max(sticker[1][j-1], sticker[1][j-2]) + map[0][j];
                sticker[1][j] = Math.max(sticker[0][j-1], sticker[0][j-2]) + map[1][j];
            }

            sb.append(Math.max(sticker[0][n], sticker[1][n])).append("\n");
        }

        System.out.print(sb);
    }
}