// 1920번 수 찾기
package BOJ_1920;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 오름차순 정렬
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        int[] printB = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<M; i++){
            int left = 0;
            int right = N-1;            // 0 ~ N-1로 범위 설정하는 것이 중요!! (lower bound & upper bound)
            int mid;

            while ( left <= right ) {
                mid = (left + right) / 2;

                // 만약 중간 값이 찾고자 하는 값이라면
                if ( A[mid] == B[i] ) {
                    printB[i] = 1;
                    break;
                }
                // 찾고자 하는 값이 중간 값보다 작다면
                else if( A[mid] > B[i] ){
                    right = mid-1;
                }
                // 찾고자 하는 값이 중간 값보다 크다면
                else if ( A[mid] < B[i] ) {
                    left = mid+1;
                }
            }
        }

        for (int i=0; i<M; i++) {
            System.out.println(printB[i]);
        }
    }
}
