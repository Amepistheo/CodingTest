// 2609번 최대공약수와 최소공배수
package BOJ_2609;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int D = gcd(A, B);

        System.out.println(D);
        System.out.println((A * B) / D);

    }

    // 최소공배수 구하는 함수
    static int gcd (int A, int B) {
        while (B != 0) {
            // 나머지
            int R = A % B;

            A = B;
            B = R;
        }

        return A;
    }
}