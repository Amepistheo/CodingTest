// 20437번 문자열 게임 2
package BOJ_20437;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                sb.append("1").append(" ").append("1").append("\n");
                continue;
            }

            int[] alphabet = new int[26];

            for (int j = 0; j < W.length(); j++) {
                alphabet[W.charAt(j) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = -1;

            for (int j = 0; j < W.length(); j++) {
                char c = W.charAt(j);

                if (alphabet[c - 'a'] < K) {
                    continue;
                }

                int count = 1;

                for (int k = j + 1; k < W.length(); k++) {
                    if (W.charAt(k) == c) {
                        count++;
                    }

                    if (count == K) {
                        int length = k - j + 1;

                        min = Math.min(min, length);
                        max = Math.max(max, length);

                        break;
                    }
                }
            }

            if (min == Integer.MAX_VALUE || max == -1) {
                sb.append("-1");
            } else {
                sb.append(min).append(" ").append(max);
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}