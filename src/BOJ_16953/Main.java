// 16953번 A -> B
package BOJ_16953;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int count = 1;

        while (A != B) {
            // 만들고자 하는 수가 더 커지는 경우 못 만들기 떄문에 -1 출력
            if (A > B) {
                count = -1;
                break;
            }

            String strB = String.valueOf(B);

            // B의 일의 자리수가 1이 아닌 홀수인 경우에 -1 출력
            if (strB.charAt(strB.length()-1) != '1' && B % 2 != 0) {
                count = -1;
                break;
            }

            // B가 짝수인 경우 2로 나눈 몫을 넣어주고, 일의자리가 1인 경우 십의 자리까지 문자열 자르고서 long 타입으로 바꿔줌
            if (B % 2 == 0)
                B = (B/2);
            else {
                strB = strB.substring(0, strB.length()-1);
                B = Long.parseLong(strB);
            }

            count++;
        }

        System.out.println(count);
    }
}
