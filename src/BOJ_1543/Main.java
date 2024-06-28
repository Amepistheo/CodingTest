// 1543번 문서 검색
package BOJ_1543;

import java.io.*;
import java.util.*;

public class Main {

    private static String input, word;

    public static void main(String[] args) throws IOException {
        firstSetting();
        solveProblem();
    }

    private static void firstSetting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        word = br.readLine();
    }

    private static void solveProblem() {
        input = input.replaceAll(word, "0");

        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '0') {
                count++;
            }
        }

        System.out.println(count);
    }
}