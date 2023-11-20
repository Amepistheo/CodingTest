// 11656번 접미사 배열
package BOJ_11656;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        String[] word = new String[input.length()];

        for (int i=0; i<input.length(); i++) {
            word[i] = input.substring(i,input.length());
        }

        Arrays.sort(word);

        for (int i=0; i<input.length(); i++) {
            sb.append(word[i]).append("\n");
        }

        System.out.print(sb);
    }
}