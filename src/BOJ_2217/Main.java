// 2217번 로프
package BOJ_2217;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] rope = new int[N];
        int total = Integer.MIN_VALUE;

        for (int i=0; i<N; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope);

        for (int i=0; i<N; i++) {
            total = Math.max(total, rope[i] * (N - i));
        }

        System.out.println(total);
    }
}