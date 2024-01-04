// 8393번 합
package BOJ_8393;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 1; i <= n; i++) {
            count += i;
        }

        System.out.println(count);
    }
}