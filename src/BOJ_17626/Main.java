// 17626번 Four Squares
package BOJ_17626;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] input = new int[n+1];

        input[0] = 0;
        input[1] = 1;

        for (int i=2; i<=n; i++) {
            // [현재 구할 값의 개수 = 전 값 + 1] 이기 때문에 우선 가져옴
            input[i] = input[i-1];

            // 현재 값과 i-j*j를 비교하여 더 작은 값을 input[i]에 저장
            for (int j=1; j*j<=i; j++) {
                input[i] = Math.min(input[i], input[i-j*j]);
            }

            // 최소값 저장되어 있기 때문에 +1 해서 마무리
            input[i]++;
        }

        System.out.println(input[n]);
    }
}
