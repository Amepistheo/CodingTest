// 10039번 평균 점수
package BOJ_10039;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;

        for (int i=0; i<5; i++) {
            int grade = Integer.parseInt(br.readLine());

            if (grade < 40)
                sum += 40;
            else
                sum += grade;
        }

        System.out.println(sum / 5);
    }
}