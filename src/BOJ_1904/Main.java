// 1904번 01타일
package BOJ_1904;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 배열의 범위를 N+1로 하면 N = 1일 떄 N[1]에 접근시 값이 없는 index 범위에 접근하여 런타임 에러남
        // 배열의 범위는 넓게 잡는게 좋음
        // 범위도 1000001로 설정한 이유도 N번째 부분의 값을 구하기 위해 N+1 해준 것과 같은 원리
        long[] A = new long[1000001];

        A[0] = 0;
        A[1] = 1;
        A[2] = 2;

        if (N >= 3) {
            for (int i=3; i<=N; i++) {
                A[i] = (A[i-1] + A[i-2]) % 15746;
            }
        }

        System.out.println(A[N]);
    }
}
