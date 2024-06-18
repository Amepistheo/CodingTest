// 11637번 인기 투표
package BOJ_11637;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] vote = new int[n+1];

            int max = Integer.MIN_VALUE;
            int sum = 0;
            int count = 0;
            int winner = 0;

            for (int j = 1; j <= n; j++) {
                vote[j] = Integer.parseInt(br.readLine());
                sum += vote[j];

                if (vote[j] > max) {
                    max = vote[j];
                    count = 1;
                    winner = j;
                }
                else if (vote[j] == max) {
                    count++;
                }
            }

            if (count == n) {
                sb.append("no winner").append("\n");
                continue;
            }

            if (count > 1) {
                sb.append("no winner").append("\n");
            }
            else {
                if (max > (sum / 2)) {
                    sb.append("majority winner ").append(winner).append("\n");
                }
                else {
                    sb.append("minority winner ").append(winner).append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}