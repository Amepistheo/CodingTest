// 동적계획법 - 정수 삼각형
package PG_정수_삼각형;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        int[][] ans = new int[triangle.length + 1][triangle.length + 1];

        for (int i = 1; i <= triangle.length; i++) {
            for (int j = 1; j <= triangle[i-1].length; j++) {
                ans[i][j] = triangle[i-1][j-1];
            }
        }

        for (int i = 1; i < ans.length; i++) {
            for (int j = 1; j < ans.length; j++) {
                ans[i][j] += Math.max(ans[i-1][j-1], ans[i-1][j]);
                answer = Math.max(answer, ans[i][j]);
            }
        }

        return answer;
    }
}