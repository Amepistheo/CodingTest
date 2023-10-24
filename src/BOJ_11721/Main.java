// 11721번 열 개씩 끊어 출력하기
package BOJ_11721;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        Queue<Character> q = new LinkedList<>();

        for (int i=0; i<input.length(); i++) {
            q.offer(input.charAt(i));
        }

        while (q.size()>= 10) {
            for (int i=0; i<10; i++) {
                sb.append(q.poll());
            }

            sb.append("\n");
        }

        while (!q.isEmpty()) {
            sb.append(q.poll());
        }

        System.out.println(sb);
    }
}