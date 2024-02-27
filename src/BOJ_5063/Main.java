// 5063번 TGN
package BOJ_5063;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        long N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            long r = Integer.parseInt(st.nextToken());
            long e = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());

            if ((e - c) > r) {
                sb.append("advertise").append("\n");
            }
            else if ((e - c) < r) {
                sb.append("do not advertise").append("\n");
            }
            else {
                sb.append("does not matter").append("\n");
            }
        }

        System.out.print(sb);
    }
}