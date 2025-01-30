// 68645번 삼각 달팽이
package PG_68645;

class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int[] answer = new int[(n * (n + 1)) / 2];

        int x = -1;
        int y = 0;
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if ((i % 3) == 0) {
                    x++;
                } else if ((i % 3) == 1) {
                    y++;
                } else if ((i % 3) == 2) {
                    x--;
                    y--;
                }

                arr[x][y] = num;
                num++;
            }
        }

        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index] = arr[i][j];
                index++;
            }
        }

        return answer;
    }
}