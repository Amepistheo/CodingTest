// 1018번 체스판 다시 칠하기
package BOJ_1018;

import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] map;
    static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        map = new boolean[row][col];

        for (int i=0; i<row; i++) {
            String input = br.readLine();

            for (int j=0; j<col; j++) {
                if (input.charAt(j) == 'W')
                    map[i][j] = true;
                else
                    map[i][j] = false;
            }
        }

        for (int i=0; i<row-7; i++) {
            for (int j=0; j<col-7; j++) {
                search(i, j);
            }
        }

        System.out.println(min);
    }

    // x, y는 체스판의 시작 위치
    // check는 다음 칸 반대 컬러가 오도록 바꿔줌
    public static void search(int x, int y) {
        int count = 0;
        boolean check = map[x][y];

        for (int i=x; i<x+8; i++) {
            for (int j=y; j<y+8; j++) {
                if (map[i][j] != check)
                    count++;

                check = !check;
            }

            check = !check;
        }

        // <흰색으로 시작하는 경우 vs 검은색으로 시작하는 경우> 비교하여 더 작은 값 가져오기
        count = Math.min(count, 64-count);
        // 가장 교체 수가 적은 케이스의 최솟값 가져오기
        min = Math.min(min, count);
    }
}
