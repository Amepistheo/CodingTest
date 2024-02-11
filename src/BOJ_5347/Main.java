// 5347번 LCM
package BOJ_5347;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());

            long lcm = gcd(a, b);

            sb.append((a * b) / lcm).append("\n");
        }

        System.out.print(sb);
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;

            a = b;
            b = r;
        }

        return a;
    }
}