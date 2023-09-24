// 1932번 정수 삼각형
package BOJ_1932;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] triangle = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = -1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);

                if (max < triangle[i][j])
                    max = triangle[i][j];
            }
        }

        System.out.println(max);
    }
}