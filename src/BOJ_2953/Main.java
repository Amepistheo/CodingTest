// 2953번 나는 요리사다
package BOJ_2953;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[][] score = new int[6][6];

        int max = 0;

        for (int i = 1; i <= 5; i++) {
            st = new StringTokenizer(br.readLine());

            int sum = 0;

            for (int j = 1; j <= 4; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
                sum += score[i][j];
            }

            score[i][5] = sum;

            max = Math.max(max, sum);
        }

        for (int i = 1; i <= 5; i++) {
            if (score[i][5] == max) {
                sb.append(i).append(" ").append(score[i][5]);
                break;
            }
        }

        System.out.println(sb);
    }
}