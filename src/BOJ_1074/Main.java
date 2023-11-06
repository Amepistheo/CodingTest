// 1074번 Z
package BOJ_1074;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);

        int count = 0;
        int x = 0;
        int y = 0;

        while (size > 0) {
            size /= 2;

            if (r < x + size && c < y + size) {
                count += 0;
            }
            else if (r < x + size) {
                count += (size * size);
                y += size;
            }
            else if (c < y + size) {
                count += (size * size * 2);
                x += size;
            }
            else {
                count += (size * size * 3);
                x += size;
                y += size;
            }

            if (size == 1) {
                System.out.println(count);
                break;
            }
        }
    }
}