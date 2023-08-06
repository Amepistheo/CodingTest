// 13305번 주유소
package BOJ_13305;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());                    // 도시의 개수
        long[] lengthArr = new long[N];                             // 도로의 길이
        long[] priceArr = new long[N];                              // 주유소의 리터당 가격

        st = new StringTokenizer(br.readLine());

        // 도로의 길이 입력
        for (int i=0; i<N-1; i++) {
            lengthArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        // 주유소의 리터당 가격 입력
        for (int i=0; i<N; i++) {
            priceArr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;                                               // 출력할 최소비용
        long min = priceArr[0];

        for (int i=0; i<N-1; i++) {
            // 최소 가격 갱신
            if (priceArr[i] < min)
                min = priceArr[i];

            sum += (lengthArr[i] * min);
        }

        System.out.println(sum);
    }
}