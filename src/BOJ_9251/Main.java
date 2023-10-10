// 9251번 LCS
package BOJ_9251;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input1 = br.readLine();
        String input2 = br.readLine();

        char[] str1 = new char[input1.length()+1];
        char[] str2 = new char[input2.length()+1];

        int[][] dp = new int[str1.length+1][str2.length+1];

        // 첫 번째 수열 저장
        for (int i=0; i<input1.length(); i++) {
            str1[i+1] = input1.charAt(i);
        }

        // 두 번째 수열 저장
        for (int i=0; i<input2.length(); i++) {
            str2[i+1] = input2.charAt(i);
        }

        // 두 문자가 같다면 왼쪽 위 대각선의 값 +1 해줌
        // 두 문자가 다르다면 왼쪽이나 위쪽 값 중 큰 값 +1 해줌
        for (int i=2; i<=str1.length; i++) {
            for (int j=2; j<=str2.length; j++) {
                if (str1[i-1] == (str2[j-1]))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        System.out.println(dp[str1.length][str2.length]);
    }
}