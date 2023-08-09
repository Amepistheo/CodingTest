// 2751번 수 정렬하기 2
package BOJ_2751;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        long[] result = new long[N];

        for (int i=0; i<N; i++) {
            result[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(result);

        for (int i=0; i<N; i++) {
            sb.append(result[i]).append('\n');
        }

        System.out.print(sb);
    }
}
