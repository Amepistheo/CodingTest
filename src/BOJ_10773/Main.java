// 10773번 제로
package BOJ_10773;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        int K = Integer.parseInt(br.readLine());

        for (int i=0; i<K; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0)
                stack.pop();
            else
                stack.push(input);
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
