// 1259번 팰린드롬수
package BOJ_1259;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();

            if (input.equals("0")) {
                break;
            }

            String s1 = input.substring(0, input.length()/2);
            String s2;

            if (input.length() % 2 == 0) {
                s2 = input.substring(input.length()/2);
            }
            else {
                s2 = input.substring(input.length()/2 + 1);
            }

            StringBuilder temp = new StringBuilder(s2);
            s2 = temp.reverse().toString();

            if (s1.equals(s2)) {
                sb.append("yes").append("\n");
            }
            else {
                sb.append("no").append("\n");
            }
        }

        System.out.print(sb);
    }
}