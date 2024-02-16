// 10886번 0 = not cute / 1 = cute
package BOJ_10886;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cute = new int[2];

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            cute[Integer.parseInt(br.readLine())]++;
        }

        if (cute[0] < cute[1]) {
            System.out.println("Junhee is cute!");
        }
        else {
            System.out.println("Junhee is not cute!");
        }
    }
}