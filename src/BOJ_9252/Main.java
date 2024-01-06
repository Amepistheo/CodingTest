// 9252번 LCS 2
package BOJ_9252;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input1 = br.readLine();
        String input2 = br.readLine();

        int length1 = input1.length();
        int length2 = input2.length();

        int[][] dp = new int[length1+1][length2+1];

        for (int i=1; i<=length1; i++) {
            for (int j=1; j<=length2; j++) {
                if (input1.charAt(i-1) == input2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        sb.append(dp[length1][length2]).append("\n");

        Stack<Character> stack = new Stack<>();

        while (length1 > 0 && length2 > 0) {
            if (dp[length1][length2] == dp[length1-1][length2]) {
                length1--;
            }
            else if (dp[length1][length2] == dp[length1][length2-1]) {
                length2--;
            }
            else {
                stack.push(input1.charAt(length1-1));
                length1--;
                length2--;
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}