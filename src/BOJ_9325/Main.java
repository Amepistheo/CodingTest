// 9325번 얼마?
package BOJ_9325;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int s = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int sum = 0;

            if (n != 0) {
                for (int j = 0; j < n; j++) {
                    st = new StringTokenizer(br.readLine());

                    int q = Integer.parseInt(st.nextToken());
                    int p = Integer.parseInt(st.nextToken());

                    sum += (q * p);
                }
            }

            sb.append(s + sum).append("\n");
        }

        System.out.print(sb);
    }
}