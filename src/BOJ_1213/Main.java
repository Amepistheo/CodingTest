// 1213번 팰린드롬 만들기
package BOJ_1213;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] alphabet = new int[26];
        int oddNum = 0;                                 // 알파벳의 홀수 개수
        int position = 0;

        String input = br.readLine();                   // 입력받은 문자열

        // 각 알파벳의 개수 배열에 저장
        for (int i=0; i<input.length(); i++) {
            for (int j=0; j<26; j++) {
                if (input.charAt(i) == (char)('A'+j))
                    alphabet[j]++;
            }
        }

        // 홀수 개수 세기 (홀수의 개수가 2개 이상이면 불가능)
        for (int i=0; i<26; i++) {
            if (alphabet[i] % 2 == 1) {
                oddNum++;
                position = i;
            }

            if (oddNum >= 2) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        for (int i=0; i<26; i++) {
            for (int j=0; j<alphabet[i]/2; j++) {
                sb.append((char)('A'+i));
            }
        }

        String result = sb.toString();

        if (oddNum == 1) {
            result += ((char)('A'+position));
        }

        result += sb.reverse().toString();

        System.out.println(result);
    }
}