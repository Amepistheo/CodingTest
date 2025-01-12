// 1755번 숫자놀이
package BOJ_1755;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] sort = {8, 5, 4, 9, 1, 7, 6, 3, 2, 0};

        int count = 0;

        for (int i = 0; i < 10; i++) {
            if (M <= sort[i] && sort[i] <= N) {
                sb.append(sort[i]).append(" ");
                count++;

                if (count % 10 == 0) {
                    sb.append("\n");
                }
            }

            if ((M - 10) <= sort[i] * 10) {
                for (int j = 0; j < 10; j++) {
                    int num = sort[i] * 10 + sort[j];

                    if (num < 10 || num < M || N < num) {
                        continue;
                    }

                    sb.append(num).append(" ");
                    count++;

                    if (count % 10 == 0) {
                        sb.append("\n");
                    }
                }
            }
        }

        System.out.print(sb);
    }
}