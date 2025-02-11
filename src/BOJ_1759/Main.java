// 1759번 암호 만들기
package BOJ_1759;

import java.io.*;
import java.util.*;

public class Main {

    static int L, C;

    static String[] chars;
    static String[] code;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = new String[C];
        code = new String[L];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken();
        }

        Arrays.sort(chars);
        makeCode(0, 0);

        System.out.print(sb);
    }

    private static void makeCode(int left, int length) {
        if (length == L) {
            if (isValid()) {
                for (String word : code) {
                    sb.append(word);
                }

                sb.append("\n");
            }

            return;
        }

        for (int i = left; i < C; i++) {
            code[length] = chars[i];
            makeCode(i + 1, length + 1);
        }
    }

    private static boolean isValid() {
        int con = 0;
        int vow = 0;

        for (String s : code) {
            if (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o")|| s.equals("u")) {
                vow++;
            } else {
                con++;
            }
        }

        return con >= 2 && vow >= 1;
    }
}