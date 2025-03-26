// 9935번 문자열 폭발
package BOJ_9935;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        String str = br.readLine();
        String bomb = br.readLine();

        int sLength = str.length();
        int bLength = bomb.length();

        char b = bomb.charAt(bLength - 1);

        for (int i = 0; i < sLength; i++) {
            char c = str.charAt(i);
            stack.push(c);

            if (stack.size() < bLength) {
                continue;
            }

            if (b != c) {
                continue;
            }

            boolean isExist = true;

            for (int j = 0; j < bLength; j++) {
                if (stack.get(stack.size() - bLength + j) != bomb.charAt(j)) {
                    isExist = false;
                    break;
                }
            }

            if (isExist) {
                for (int j = 0; j < bLength; j++) {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            sb.append("FRULA");
        } else {
            int size = stack.size();

            for (int i = 0; i < size; i++) {
                sb.append(stack.pop());
            }

            sb.reverse();
        }

        System.out.println(sb);
    }
}