// 2531번 회전 초밥
package BOJ_2531;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        int[] eat = new int[d + 1];

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for (int i = 0; i < k; i++) {
            if (eat[sushi[i]] == 0) {
                count++;
            }

            eat[sushi[i]]++;
        }

        int max = (eat[c] == 0) ? count + 1 : count;

        for (int i = 1; i < N; i++) {
            int end = (i + k - 1) % N;

            if (eat[sushi[end]] == 0) {
                count++;
            }

            eat[sushi[end]]++;
            eat[sushi[i - 1]]--;

            if (eat[sushi[i - 1]] == 0) {
                count--;
            }

            if (eat[c] == 0) {
                max = Math.max(max, count + 1);
            } else {
                max = Math.max(max, count);
            }
        }

        System.out.println(max);
    }
}