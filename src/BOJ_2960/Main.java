// 2960번 에라토스테네스의 체
package BOJ_2960;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] num = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            num[i] = i;
        }

        for (int i = 2; i <= N; i++) {
            if (num[i] == 0) {
                continue;
            }

            for (int j = i; j <= N; j += i) {
                if (num[j] != 0) {
                    num[j] = 0;
                    K--;

                    if (K == 0) {
                        System.out.println(j);
                        break;
                    }
                }
            }
        }
    }
}