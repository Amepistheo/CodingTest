// 2693번 N번째 큰 수
package BOJ_2693;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Integer[] num = new Integer[10];

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 10; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(num, Collections.reverseOrder());

            sb.append(num[2]).append("\n");
        }

        System.out.print(sb);
    }
}