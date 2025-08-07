// 19951번 태상이의 훈련소 생활
package BOJ_19951;

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

        int[] ground = new int[1000000];
        int[] order = new int[1000000];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            ground[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            order[a] += k;
            order[b + 1] -= k;
        }

        for (int i = 1; i <= N; i++) {
            order[i] += order[i - 1];
            ground[i] += order[i];
        }

        for (int i = 1; i <= N; i++) {
            sb.append(ground[i]).append(" ");
        }

        System.out.println(sb);
    }
}