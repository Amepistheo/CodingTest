// 25640번 MBTI
package BOJ_25640;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String jinho = br.readLine();

        int N = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 0; i < N; i++) {
            String mbti = br.readLine();

            if (mbti.equals(jinho)) {
                count++;
            }
        }

        System.out.println(count);
    }
}