// 27172번 수 나누기 게임
package BOJ_27172;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] card = new int[N + 1];
        int[] list = new int[1000001];
        int[] score = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
            list[card[i]] = i;
        }

        for (int i = 1; i <= N; i++) {
            int num = card[i];

            for (int j = num * 2; j <= 1000000; j += num) {
                if (list[j] == 0) {
                    continue;
                }

                score[i]++;
                score[list[j]]--;
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(score[i]).append(" ");
        }

        System.out.println(sb);
    }
}