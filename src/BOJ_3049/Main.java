// 3049번 다각형의 대각선
package BOJ_3049;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int point = (N * (N - 1) * (N - 2) * (N - 3)) / (4 * 3 * 2);

        System.out.println(point);
    }
}