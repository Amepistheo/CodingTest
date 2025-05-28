// 1439번 뒤집기
package BOJ_1439;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int count = 0;
        char c = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (c != s.charAt(i)) {
                c = s.charAt(i);
                count++;
            }
        }

        System.out.println((count / 2) + count % 2);
    }
}