// 2775번 부녀회장이 될테야
package BOJ_2775;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[][] apart = new int[15][15];

        // 0층에는 i호수에 i명이 거주중
        for (int i=1; i<=14; i++) {
            apart[0][i] = i;
        }

        // k층 n호수 사는 사람의 수 = (k층 n-1호수) + (k-1층 n호수)
        for (int i=1; i<=14; i++) {
            for (int j=1; j<=14; j++) {
                apart[i][j] = apart[i][j-1] + apart[i-1][j];
            }
        }

        for (int i=0; i<T; i++) {
            int k = Integer.parseInt(br.readLine());            // k층
            int n = Integer.parseInt(br.readLine());            // n호

            sb.append(apart[k][n]).append("\n");
        }

        System.out.print(sb);
    }
}