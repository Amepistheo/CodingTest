// 11501번 주식
package BOJ_11501;

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

            int[] day = new int[N];

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                day[j] = Integer.parseInt(st.nextToken());
            }

            int sell = day[N-1];
            long total = 0;

            for (int j = N-2; j >= 0; j--) {
                if (day[j] <= sell) {
                    total += (sell - day[j]);
                }
                else {
                    sell = day[j];
                }
            }

            sb.append(total).append("\n");
        }

        System.out.print(sb);
    }
}