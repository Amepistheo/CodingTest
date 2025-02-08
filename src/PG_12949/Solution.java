// 12949번 행렬의 곱셈
package PG_12949;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int col = arr2[0].length;
        int length = arr1[0].length;

        int[][] answer = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int sum = 0;

                for (int k = 0; k < length; k++) {
                    sum += (arr1[i][k] * arr2[k][j]);
                }

                answer[i][j] = sum;
            }
        }

        return answer;
    }
}