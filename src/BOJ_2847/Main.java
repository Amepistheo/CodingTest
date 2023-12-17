// 2847번 게임을 만든 동준이
package BOJ_2847;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] score = new int[N];
        int count = 0;

        for (int i=0; i<N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        for (int i= N-1; i>0; i--) {
            if (score[i] <= score[i-1]) {
                count += (score[i-1] - score[i] + 1);
                score[i-1] = score[i] - 1;
            }
        }

        System.out.println(count);
    }
}