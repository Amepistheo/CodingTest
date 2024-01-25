// 10811번 바구니 뒤집기
package BOJ_10811;

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

        int[] basket = new int[N+1];

        for (int i = 1; i <= N; i++) {
            basket[i] = i;
        }

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            int seq = 0;

            for (int t = i; t <= (i + j) / 2; t++) {
                int temp = basket[t];
                basket[t] = basket[j - seq];
                basket[j - seq] = temp;
                seq++;
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(basket[i]).append(" ");
        }

        System.out.println(sb);
    }
}