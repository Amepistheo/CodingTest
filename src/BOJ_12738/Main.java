// 12738번 가장 긴 증가하는 부분 수열 3
package BOJ_12738;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int A = Integer.parseInt(br.readLine());

        int[] seq = new int[A];
        List<Integer> dp = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < A; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < A; i++) {
            if (dp.isEmpty() || dp.get(dp.size() - 1) < seq[i]) {
                dp.add(seq[i]);
            }
            else {
                int left = 0;
                int right = dp.size() - 1;

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (dp.get(mid) >= seq[i]) {
                        right = mid;
                    }
                    else {
                        left = mid + 1;
                    }
                }

                dp.set(right, seq[i]);
            }
        }

        System.out.println(dp.size());
    }
}