// 2018번 수들의 합 5
package BOJ_2018;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int left = 1;
        int right = 1;
        int sum = 1;

        int count = 0;

        while (left <= right) {
            if (sum == N) {
                count++;
            }

            if (sum < N) {
                right++;
                sum += right;
            }
            else if (sum >= N){
                sum -= left;
                left++;
            }
        }

        System.out.println(count);
    }
}