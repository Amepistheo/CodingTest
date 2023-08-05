// 11047번 동전 0
package BOJ_11047;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());           // 동전의 종류
        int K = Integer.parseInt(st.nextToken());           // 만들어야하는 가격

        Integer[] priceArr = new Integer[N];

        int count = 0;                                      // 최소 동전의 개수
        int change = K;                                     // 계산 이후의 거스름돈

        for (int i=0; i<N; i++) {
            priceArr[i] = Integer.parseInt(br.readLine());
        }

        // 배열 내림차순 정렬
        Arrays.sort(priceArr, Collections.reverseOrder());

        for (int i=0; i<N; i++) {
            if (priceArr[i] > change)
                continue;

            count += (change / priceArr[i]);
            change %= priceArr[i];
        }

        System.out.println(count);
    }
}