// 1652번 누울 자리를 찾아라
package BOJ_1652;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[101][101];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }

            map[i][N] = 'X';
            map[N][i] = 'X';
        }

        int row = 0;
        int col = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-1; j++) {
                if (map[i][j] == '.' && map[i][j+1] == '.' && map[i][j+2] == 'X') {
                    row++;
                }
                if (map[j][i] == '.' && map[j+1][i] == '.' && map[j+2][i] == 'X') {
                    col++;
                }
            }
        }

        System.out.println(row + " " + col);
    }
}