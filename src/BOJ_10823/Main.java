// 10823번 더하기 2
package BOJ_10823;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            String input = br.readLine();

            if (input == null) {
                break;
            }

            sb.append(input);
        }

        st = new StringTokenizer(sb.toString(), ",");

        int count = 0;

        while (st.hasMoreTokens()) {
            count += Integer.parseInt(st.nextToken());
        }

        System.out.println(count);
    }
}