// 2822번 점수 계산
package BOJ_2822;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] score = new int[8][2];
        int[] total = new int[5];
        int count = 0;

        for (int i=0; i<8; i++) {
            score[i][0] = Integer.parseInt(br.readLine());
            score[i][1] = i;
        }

        Arrays.sort(score, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for (int i=0; i<5; i++) {
            count += score[i][0];
            total[i] = score[i][1] + 1;
        }

        sb.append(count).append('\n');

        Arrays.sort(total);

        for (int i=0; i<5; i++) {
            sb.append(total[i]).append(" ");
        }

        System.out.println(sb);
    }
}