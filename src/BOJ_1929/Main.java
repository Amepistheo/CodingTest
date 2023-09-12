// 1929번 소수 구하기
package BOJ_1929;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] prime = new int[1000001];

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 0과 1은 소수가 아니기 때문에 0
        prime[0] = prime[1] = 0;

        for (int i=2; i<=N; i++) {
            prime[i] = i;
        }

        for (int i=2; i<=N; i++) {
            if (prime[i] == 0)
                continue;

            // 소수의 배수는 소수를 약수로 가지기에 제외시킴
            for (int j=2*i; j<=N; j+=i) {
                prime[j] = 0;
            }
        }

        for (int i=M; i<=N; i++) {
            if (prime[i] != 0)
                sb.append(prime[i]).append("\n");
        }

        System.out.print(sb);
    }
}