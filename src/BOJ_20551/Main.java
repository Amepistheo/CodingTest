// 20551번 Sort 마스터 배지훈의 후계자
package BOJ_20551;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < M; i++) {
            int question = Integer.parseInt(br.readLine());

            int left = 0;
            int right = N;
            boolean success = false;

            while (left < right) {
                int mid = (left + right) / 2;

                if (question > arr[mid]) {
                    left = mid + 1;
                }
                else {
                    right = mid;
                }

                if (question == arr[mid]) {
                    success = true;
                }
            }

            if (!success) {
                sb.append(-1).append("\n");
            }
            else {
                sb.append(right).append("\n");
            }
        }

        System.out.print(sb);
    }
}