// 10808번 알파벳 개수
package BOJ_10808;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] alphabet = new int[26];

        String input = br.readLine();

        for (int i=0; i<input.length(); i++) {
            alphabet[input.charAt(i)-97]++;
        }

        for (int i=0; i<26; i++) {
            sb.append(alphabet[i]).append(" ");
        }

        System.out.println(sb);
    }
}