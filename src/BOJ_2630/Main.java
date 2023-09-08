// 2630번 색종이 만들기
package BOJ_2630;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;

    static int white = 0;
    static int blue = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void partition(int row, int col, int size) {
        if (colorCheck(row, col, size)) {
            if (board[row][col] == 0)
                white++;
            else
                blue++;

            return;
        }

        int newSize = size / 2;

        partition(row, col, newSize);                           // 2사분면
        partition(row, col+newSize, newSize);               // 1사분면
        partition(row+newSize, col, newSize);               // 3사분면
        partition(row+newSize, col+newSize, newSize);   // 4사분면
    }

    // 현재 파티션의 컬러가 같은지 체크
    public static boolean colorCheck(int row, int col, int size) {
        // 첫 번째 원소를 기준으로 검사
        int color = board[row][col];

        for (int i=row; i<row+size; i++) {
            for (int j=col; j<col+size; j++) {
                // 색상이 같지 않으면 false
                if (board[i][j] != color)
                    return false;
            }
        }

        // 해당하지 않으면 true
        return true;
    }
}
