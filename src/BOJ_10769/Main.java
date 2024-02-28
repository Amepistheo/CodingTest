// 10769번 행복한지 슬픈지
package BOJ_10769;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int happy = 0;
        int sad = 0;

        if (input.length() >= 3) {
            for (int i = 0; i < input.length() - 3; i++) {
                if (input.charAt(i) == ':' && input.charAt(i + 1) == '-' && input.charAt(i + 2) == ')') {
                    happy++;
                }
                else if (input.charAt(i) == ':' && input.charAt(i + 1) == '-' && input.charAt(i + 2) == '(') {
                    sad++;
                }
            }
        }

        if (happy == 0 && sad == 0) {
            System.out.println("none");
        }
        else if (happy > sad) {
            System.out.println("happy");
        }
        else if (happy < sad) {
            System.out.println("sad");
        }
        else if (happy == sad) {
            System.out.println("unsure");
        }
    }
}