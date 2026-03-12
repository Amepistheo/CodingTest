// 2800번 괄호 제거
package BOJ_2800;

import java.io.*;
import java.util.*;

public class Main {

    private static Set<String> set = new TreeSet<>();

    private static int[] bracket;
    private static boolean[] check;

    private static String str;
    private static int index = 1;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        str = br.readLine();
        bracket = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                bracket[i] = index;
                stack.add(index);
                index++;
                count++;
            } else if (str.charAt(i) == ')') {
                bracket[i] = stack.pop();
            }
        }

        check = new boolean[count + 1];
        dfs(1);
        set.remove(str);

        for (String s : set) {
            sb.append(s).append("\n");
        }

        System.out.print(sb);
    }

    private static void dfs(int index) {
        if (index > count + 1) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (bracket[i] != 0 && check[bracket[i]]) {
                continue;
            }

            sb.append(str.charAt(i));
        }

        set.add(sb.toString());

        for (int i = index; i <= count; i++) {
            check[i] = true;
            dfs(i + 1);
            check[i] = false;
        }
    }
}