// 2579번 계단 오르기
package BOJ_2579;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());            // 계단의 개수

        int[] inputArr = new int[N+2];
        int[] score = new int[N+2];

        // 각 계단의 점수 입력
        for (int i=1; i<=N; i++) {
            inputArr[i] = Integer.parseInt(br.readLine());
        }

        score[1] = inputArr[1];
        score[2] = inputArr[1] + inputArr[2];

        // 각 계단을 밟았을 때의 현재까지의 최댓값 계산
        // n-3과 n-1을 거쳐서 n으로 오는 경우 vs n-2를 거쳐서 n으로 오는 경우
        for (int i=3; i<=N; i++)
            score[i] = Math.max(score[i-3]+inputArr[i-1], score[i-2]) + inputArr[i];

        System.out.println(score[N]);
    }
}
