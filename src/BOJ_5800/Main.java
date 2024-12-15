// 5800번 성적 통계
package BOJ_5800;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            Integer[] num = new Integer[N];

            for (int j = 0; j < N; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(num, Collections.reverseOrder());

            int min = 0;

            for (int j = 1; j < N; j++) {
                min = Math.max(min, num[j-1] - num[j]);
            }

            sb.append("Class ").append(i+1).append("\n");
            sb.append("Max ").append(num[0]).append(", Min ").append(num[N-1]).append(", Largest gap ").append(min).append("\n");
        }

        System.out.print(sb);
    }
}