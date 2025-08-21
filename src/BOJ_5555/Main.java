// 5555번 반지
package BOJ_5555;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();

            if (tmp.contains(str)) {
                count++;
                continue;
            }

            boolean isExist = false;

            for (int j = 0; j < str.length(); j++) {
                String s = tmp.substring(j + 1) + tmp.substring(0, j + 1);

                if (isExist) {
                    continue;
                }

                if (s.contains(str)) {
                    count++;
                    isExist = true;
                }
            }
        }

        System.out.println(count);
    }
}