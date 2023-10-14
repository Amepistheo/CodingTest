// 1193번 분수찾기
package BOJ_1193;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int line = 1;

        while (X > line) {
            X -= line;
            line++;
        }

        if (line % 2 == 0)
            System.out.println(X + "/" + (line-X+1));
        else
            System.out.println((line-X+1) + "/" + X);
    }
}