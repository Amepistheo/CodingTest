// 9461번 파도반 수열
package BOJ_9461;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());            // 테스트 케이스의 개수
        long[] P = new long[100000];

        P[1] = P[2] = P[3] = 1;
        P[4] = P[5] = 2;

        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());

            // 변의 길이 구하는 점화식
            for (int j=6; j<=N; j++)
                P[j] = P[j-1] + P[j-5];

            sb.append(P[N]).append('\n');
        }

        System.out.print(sb);
    }
}