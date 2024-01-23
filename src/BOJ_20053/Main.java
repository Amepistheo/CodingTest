// 20053번 최소, 최대 2
package BOJ_20053;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[] input = new int[N];

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                input[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(input);

            sb.append(input[0]).append(" ").append(input[N - 1]).append("\n");
        }

        System.out.print(sb);
    }
}