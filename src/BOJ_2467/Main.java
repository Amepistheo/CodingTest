// 2467번 용액
package BOJ_2467;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] solution = new int[N];
        int[] answer = new int[2];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        int value = Integer.MAX_VALUE;

        int left = 0;
        int right = N - 1;

        while (left < right) {
            int sum = solution[left] + solution[right];

            if (Math.abs(sum) < Math.abs(value)) {
                value = sum;
                answer[0] = left;
                answer[1] = right;
            }

            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                break;
            }
        }

        sb.append(solution[answer[0]]).append(" ").append(solution[answer[1]]);

        System.out.println(sb);
    }
}