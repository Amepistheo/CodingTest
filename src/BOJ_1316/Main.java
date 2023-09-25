// 1316번 그룹 단어 체커
package BOJ_1316;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i=0; i<N; i++) {
            String input = br.readLine();

            boolean[] alphabet = new boolean[26];
            boolean group = true;

            for (int j=0; j<input.length(); j++) {
                int index = input.charAt(j) - 'a';

                if (alphabet[index]) {
                    if (input.charAt(j) != input.charAt(j-1)) {
                        group = false;
                        break;
                    }
                }
                else
                    alphabet[index] = true;
            }

            if (group)
                count++;
        }

        System.out.println(count);
    }
}