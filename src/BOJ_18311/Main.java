// 18311번 왕복
package BOJ_18311;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        int[] course = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            course[i] = Integer.parseInt(st.nextToken());
        }

        boolean reverse = false;

        for (int i = 0; i < N; i++) {
            K -= course[i];

            if (K < 0) {
                System.out.println(i + 1);
                reverse = true;
                break;
            }
        }

        if (!reverse) {
            for (int i = N - 1; i >= 0; i--) {
                K -= course[i];

                if (K < 0) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
    }
}