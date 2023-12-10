// 2566번 최댓값
package BOJ_2566;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[][] map = new int[9][9];
        int max = Integer.MIN_VALUE;
        int x = 0, y = 0;

        for (int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        sb.append(max).append('\n');

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (map[i][j] == max) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        sb.append(x+1).append(" ").append(y+1);

        System.out.println(sb);
    }
}