// 43165번 타겟 넘버
package PG_43165;

class Solution {

    private static int count = 0;
    private static int n;
    private static int targetNum;
    private static int[] numList;

    public int solution(int[] numbers, int target) {
        n = numbers.length;
        numList = numbers;
        targetNum = target;

        dfs(0, 0);

        return count;
    }

    private void dfs(int depth, int sum) {
        if (depth >= n) {
            if (sum == targetNum) {
                count++;
            }

            return;
        }

        dfs(depth + 1, sum - numList[depth]);
        dfs(depth + 1, sum + numList[depth]);
    }
}