// 14912번 숫자 빈도수
package BOJ_14912;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int count = 0;

        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == (char)(d + '0')) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}