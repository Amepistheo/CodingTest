// 17390번 이건 꼭 풀어야 해!
package BOJ_17390;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] seq = new int[A+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= A; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(seq);

        for (int i = 1; i <= A; i++) {
            seq[i] += seq[i-1];
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            sb.append(seq[R] - seq[L-1]).append("\n");
        }

        System.out.print(sb);
    }
}