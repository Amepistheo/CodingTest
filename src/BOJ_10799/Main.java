// 10799번 쇠막대기
package BOJ_10799;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Stack<String> stack = new Stack<>();

        String s = br.readLine();

        int result = 0;

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push("(");
            }
            else if (s.charAt(i) == ')') {
                stack.pop();

                if (s.charAt(i-1) == '(') {
                    result += stack.size();
                }
                else {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}