// 12931번 두 배 더하기
package BOJ_12931;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] B = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        while (true) {
            int zero = 0;
            boolean isExist = false;

            for (int i = 0; i < N; i++) {
                if (B[i] == 0) {
                    zero++;
                }
            }

            if (zero == N) {
                break;
            }

            for (int i = 0; i < N; i++) {
                if (B[i] % 2 != 0) {
                    B[i]--;
                    count++;
                }
            }

            for (int i = 0; i < N; i++) {
                if (B[i] == 0) {
                    continue;
                }

                if (!isExist) {
                    isExist = true;
                    count++;
                }

                B[i] /= 2;
            }
        }

        System.out.println(count);
    }
}