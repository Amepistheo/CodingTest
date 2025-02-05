// 43162번 네트워크
package PG_43162;

class Solution2 {

    static boolean[] isVisit;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        isVisit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (isVisit[i]) {
                continue;
            }

            dfs(i, n, computers);
            answer++;
        }

        return answer;
    }

    private void dfs(int x, int n, int[][] computers) {
        isVisit[x] = true;

        for (int i = 0; i < n; i++) {
            if (isVisit[i]) {
                continue;
            }

            if (computers[x][i] == 0) {
                continue;
            }

            dfs(i, n, computers);
        }
    }
}