// 11170번 0의 개수
package BOJ_11170;

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

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int count = 0;

            for (int j = N; j <= M; j++) {
                String num = String.valueOf(j);

                for (int k = 0; k < num.length(); k++) {
                    if (num.charAt(k) == '0') {
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}