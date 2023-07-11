// 2839번 설탕 배달
package BOJ_2839;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 배달해야하는 설탕의 무게
        int bag = 0;                                // 필요한 가방의 개수

        while (true) {
            if (N%5 == 0) {                         // N이 5로 나누어떨어지는 경우 / N이 0인 경우
                bag += (N/5);                       // bag의 값을 5로 나눈 몫의 수 만큼 더함
                System.out.println(bag);
                break;
            }

            else {                                  // 5로 나누어 떨어지지 않는 경우 3을 계속해서 빼줌
                N -= 3;
                bag++;                              // 가방의 개수 +1 해줌
            }

            if (N<0) {                              // 3을 빼주었을 때 N이 음수가 되는 경우 -1 출력
                System.out.println(-1);
                break;
            }
        }
    }
}