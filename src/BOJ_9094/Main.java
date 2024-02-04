// 9094번 수학적 호기심
package BOJ_9094;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int count = 0;

            for (int a = 1; a < n - 1; a++) {
                for (int b = a + 1; b < n; b++) {
                    if (((a * a) + (b * b) + m) % (a * b) == 0) {
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}