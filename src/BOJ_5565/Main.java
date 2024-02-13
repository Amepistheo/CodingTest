// 5565번 영수증
package BOJ_5565;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());

        for (int i = 0; i < 9; i++) {
            int book = Integer.parseInt(br.readLine());
            total -= book;
        }

        System.out.println(total);
    }
}