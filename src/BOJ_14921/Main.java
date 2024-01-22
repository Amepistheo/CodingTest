// 14921번 용액 합성하기
package BOJ_14921;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] solution = new int[N];

        st =  new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N-1;

        long result = Integer.MAX_VALUE;

        while (left < right) {
            long sum = solution[left] + solution[right];

            if (Math.abs(sum) < Math.abs(result)) {
                result = sum;
            }

            if (sum == 0) {
                break;
            }
            else if (sum > 0) {
                right--;
            }
            else {
                left++;
            }
        }

        System.out.println(result);
    }
}