// 1159번 농구 경기
package BOJ_1159;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] count = new int[26];
        int total = 0;

        for (int i = 0; i < N; i++) {
            String player = br.readLine();

            count[player.charAt(0) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] >= 5) {
                total++;
                sb.append((char)(i + 'a'));
            }
        }

        if (total == 0) {
            sb.append("PREDAJA");
        }

        System.out.println(sb);
    }
}