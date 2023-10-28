// 8958번 OX퀴즈
package BOJ_8958;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            String input = br.readLine();

            int sum = 0;
            int count = 0;

            for (int j=0; j<input.length(); j++) {
                if (input.charAt(j) == 'X') {
                    count = 0;
                }
                else if (input.charAt(j) == 'O') {
                    count++;
                    sum += count;
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }
}