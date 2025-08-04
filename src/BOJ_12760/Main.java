// 12760번 최후의 승자는 누구?
package BOJ_12760;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[] score = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.sort(arr[i]);
        }

        for (int i = 0; i < M; i++) {
            int maxCard = -1;

            for (int j = 0; j < N; j++) {
                if (arr[j][i] > maxCard) {
                    maxCard = arr[j][i];
                }
            }

            for (int j = 0; j < N; j++) {
                if (arr[j][i] == maxCard) {
                    score[j]++;
                }
            }
        }

        int maxScore = score[0];

        for (int i = 1; i < N; i++) {
            maxScore = Math.max(maxScore, score[i]);
        }

        for (int i = 0; i < N; i++) {
            if (score[i] == maxScore) {
                sb.append(i + 1).append(" ");
            }
        }

        System.out.println(sb);
    }
}