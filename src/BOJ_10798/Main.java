// 10798번 세로읽기
package BOJ_10798;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] word = new char[5][15];

        int max = 0;

        for (int i=0; i<5; i++) {
            String s = br.readLine();

            if (max < s.length()) {
                max = s.length();
            }

            for (int j=0; j<s.length(); j++) {
                word[i][j] = s.charAt(j);
            }
        }

        for (int i=0; i<max; i++) {
            for (int j=0; j<5; j++) {
                if (word[j][i] == '\0') {
                    continue;
                }

                sb.append(word[j][i]);
            }
        }

        System.out.println(sb);
    }
}