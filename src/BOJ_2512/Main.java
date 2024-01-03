// 2512번 예산
package BOJ_2512;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] money = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(money);

        int M = Integer.parseInt(br.readLine());

        int left = 1;
        int right = money[N-1];

        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 0;

            for (int i = 0; i < N; i++) {
                if (money[i] < mid) {
                    count += money[i];
                }
                else {
                    count += mid;
                }
            }

            if (count > M) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        System.out.println(left - 1);
    }
}