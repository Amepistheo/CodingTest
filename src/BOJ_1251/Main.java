// 1251번 단어 나누기
package BOJ_1251;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();

        String s = br.readLine();

        for (int a = 1; a < s.length() - 1; a++) {
            for (int b = a + 1; b < s.length(); b++) {
                StringBuilder sb = new StringBuilder();

                StringBuilder sb1 = new StringBuilder(s.substring(0, a));
                StringBuilder sb2 = new StringBuilder(s.substring(a, b));
                StringBuilder sb3 = new StringBuilder(s.substring(b));

                sb.append(sb1.reverse()).append(sb2.reverse()).append(sb3.reverse());

                list.add(sb.toString());
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));
    }
}