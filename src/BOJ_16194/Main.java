// 16194번 카드 구매하기 2
package BOJ_16194;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] P = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= (i / 2); j++) {
                P[i] = Math.min(P[i], P[j] + P[i - j]);
            }
        }

        System.out.println(P[N]);
    }
}