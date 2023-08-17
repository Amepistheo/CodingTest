// 9012번 괄호
package BOJ_9012;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            String str = br.readLine();

            int left = 0;
            int right = 0;

            for (int j=0; j<str.length(); j++) {
                char input = str.charAt(j);

                if (input == '(')
                    left++;
                else if (input == ')')
                    right++;

                if (left == right)
                    left = right = 0;
                else if (left < right)
                    break;
            }

            if (left == right)
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }

        System.out.print(sb);
    }
}
