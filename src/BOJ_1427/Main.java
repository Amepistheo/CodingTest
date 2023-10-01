// 1427번 소트인사이드
package BOJ_1427;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Integer[] list = new Integer[input.length()];

        for (int i=0; i<input.length(); i++) {
            list[i] = input.charAt(i) - '0';
        }

        Arrays.sort(list, Collections.reverseOrder());

        for (int i=0; i<input.length(); i++) {
            System.out.print(list[i]);
        }
    }
}