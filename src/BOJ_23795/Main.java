// 23795번 사장님 도박은 재미로 하셔야 합니다
package BOJ_23795;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long sum = 0;

        while (true) {
            long money = Integer.parseInt(br.readLine());

            if (money == -1) {
                break;
            }
            else {
                sum += money;
            }
        }

        System.out.println(sum);
    }
}