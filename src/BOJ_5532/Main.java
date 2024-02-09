// 5532번 방학 숙제
package BOJ_5532;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());

        int korean = A / C;
        if (A % C != 0) {
            korean++;
        }
        int math = B / D;
        if (B % D != 0) {
            math++;
        }

        if (korean >= math) {
            System.out.println(L - korean);
        }
        else {
            System.out.println(L - math);
        }
    }
}