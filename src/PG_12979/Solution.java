// 12979번 기지국 설치
package PG_12979;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int count = 0;
        int station = 0;
        int i = 1;

        while (i <= n) {
            if (station < stations.length && stations[station] - w <= i) {
                i = stations[station] + w + 1;
                station++;
            } else {
                i += (w * 2 + 1);
                count++;
            }
        }

        return count;
    }
}