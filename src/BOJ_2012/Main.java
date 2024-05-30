// 2012번 등수 매기기
package BOJ_2012;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] score = new int[N+1];
        long sum = 0;

        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(score);

        for (int i = 1; i <= N; i++) {
            sum += Math.abs(score[i] - i);
        }

        System.out.println(sum);
    }
}