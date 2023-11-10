// 1629번 곱셈
package BOJ_1629;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A, B, C));
    }

    private static long pow(int a, int b, int mod) {
        if (b == 0) {
            return 1;
        }

        long result = pow(a, b/2, mod);

        if (b % 2 == 0) {
            return result * result % mod;
        }
        else {
            return (result * result % mod) * a % mod;
        }
    }
}