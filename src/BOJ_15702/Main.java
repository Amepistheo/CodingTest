// 15702번 중간고사 채점
package BOJ_15702;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] score = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        String[][] student = new String[M][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N + 1; j++) {
                student[i][j] = st.nextToken();
            }
        }

        int[] sum = new int[M];

        for (int i = 0; i < M; i++) {
            for (int j = 1; j <= N; j++) {
                if (student[i][j].equals("X")) {
                    continue;
                }

                sum[i] += score[j - 1];
            }
        }

        int max = 0;
        int num = Integer.parseInt(student[0][0]);

        for (int i = 0; i < M; i++) {
            if (max < sum[i]) {
                num = Integer.parseInt(student[i][0]);
                max = sum[i];
            } else if (max == sum[i]) {
                if (Integer.parseInt(student[i][0]) < num) {
                    num = Integer.parseInt(student[i][0]);
                }
            }
        }

        System.out.println(num + " " + max);
    }
}