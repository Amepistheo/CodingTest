// 13699번 점화식
package BOJ_13699;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] t = new long[36];

        t[0] = 1;
        t[1] = 1;

        for (int i = 2; i < 36; i++) {
            for (int j = 0; j < i/2; j++) {
                t[i] += (t[j] * t[i-j-1]);
            }

            t[i] *= 2;

            if ((i % 2) == 1) {
                t[i] += (t[i/2] * t[i/2]);
            }
        }

        System.out.println(t[n]);
    }
}