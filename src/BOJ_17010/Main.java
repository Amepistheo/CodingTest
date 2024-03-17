// 17010번 Time to Decompress
package BOJ_17010;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            String x = st.nextToken();

            for (int j = 0; j < N; j++) {
                sb.append(x);
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}