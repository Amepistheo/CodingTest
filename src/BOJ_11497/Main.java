// 11497번 통나무 건너뛰기
package BOJ_11497;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] wood = new int[N];
            int[] tmp = new int[N + 1];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                wood[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(wood);

            int count = 0;

            int index = 0;
            int pos = 0;

            while (count < N / 2) {
                tmp[index] = wood[pos];
                tmp[N - 1 - index] = wood[pos + 1];

                index++;
                pos += 2;

                count++;
            }

            if (N % 2 != 0) {
                tmp[N / 2] = wood[N - 1];
            }

            tmp[N] = tmp[0];

            int max = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                max = Math.max(max, Math.abs(tmp[i] - tmp[i + 1]));
            }

            sb.append(max).append("\n");
        }

        System.out.print(sb);
    }
}