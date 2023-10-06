// 4344번 평균은 넘겠지
package BOJ_4344;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int C = Integer.parseInt(br.readLine());

        for (int i=0; i<C; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            float average = 0;
            float count = 0;
            int[] score = new int[N];

            for (int j=0; j<N; j++) {
                score[j] = Integer.parseInt(st.nextToken());
                average += score[j];
            }

            average /= N;

            for (int j=0; j<N; j++) {
                if (score[j] > average)
                    count++;
            }

            sb.append(String.format("%.3f", (count/N)*100)).append("%").append("\n");
        }

        System.out.print(sb);
    }
}