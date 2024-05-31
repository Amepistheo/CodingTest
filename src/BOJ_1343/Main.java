// 1343번 폴리오미노
package BOJ_1343;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String board = br.readLine();

        board = board.replaceAll("XXXX", "AAAA");
        board = board.replaceAll("XX", "BB");

        if (board.contains("X")) {
            System.out.println(-1);
        }
        else {
            System.out.println(board);
        }
    }
}