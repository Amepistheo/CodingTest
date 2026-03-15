// 4659번 비밀번호 발음하기
package BOJ_4659;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();

            if (s.equals("end")) {
                break;
            }

            boolean result = true;

            if (!s.matches(".*[aeiou].*")) {
                result = false;
            }

            boolean[] molist = new boolean[s.length()];

            for (int i = 0; i < s.length(); i++) {
                if (String.valueOf(s.charAt(i)).matches(".*[aeiou].*")) {
                    molist[i] = true;
                } else {
                    molist[i] = false;
                }
            }

            char last = s.charAt(0);

            for (int i = 1; i < s.length(); i++) {
                if (i > 1) {
                    if (molist[i - 2] == molist[i - 1] && molist[i - 1] == molist[i]) {
                        result = false;
                        break;
                    }
                }

                if (last == s.charAt(i)) {
                    if (s.charAt(i) != 'e' && s.charAt(i) != 'o') {
                        result = false;
                        break;
                    }
                }

                last = s.charAt(i);
            }

            if (result) {
                sb.append("<").append(s).append("> is acceptable.").append("\n");
            } else {
                sb.append("<").append(s).append("> is not acceptable.").append("\n");
            }
        }

        System.out.print(sb);
    }
}