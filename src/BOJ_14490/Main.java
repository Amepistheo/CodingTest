// 14490번 백대열
package BOJ_14490;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] str = br.readLine().split(":");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int num = gcd(n, m);

        sb.append(n / num).append(":").append(m / num);
        System.out.println(sb);
    }

    private static int gcd(int n, int m) {
        if (m % n == 0) {
            return n;
        }

        return gcd(m % n, n);
    }
}