// 13410번 거꾸로 구구단
package BOJ_13410;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] num = new int[K + 1];

        int max = 0;

        for (int i = 1; i <= K ; i++) {
            num[i] = flip(N * i);

            if (max < num[i]) {
                max = num[i];
            }
        }

        System.out.println(max);
    }

    private static int flip(int num) {
        int result = 0;

        while (num != 0) {
            result = (result * 10) + (num % 10);
            num /= 10;
        }

        return result;
    }
}