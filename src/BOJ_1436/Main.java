// 1436번 영화감독 숌
package BOJ_1436;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int num = 666;
        int count = 1;

        while (count != N) {
            num++;

            // 첫번째 값은 666, 두번째 값은 1666이기 때문에 num을 계속 증가시켜 666이라는 값을 가지고 있는지로 판별
            if (String.valueOf(num).contains("666"))
                count++;
        }

        System.out.println(num);
    }
}