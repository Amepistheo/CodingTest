// 연습문제 - 연속된 부분 수열의 합
package PG_연속된_부분_수열의_합;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int left = 0;
        int right = 0;
        int sum = 0;
        int size = sequence.length;

        for (int i = 0; i < sequence.length; i++) {
            sum += sequence[i];

            while (right < sequence.length && k < sum) {
                sum -= sequence[left];
                left++;
            }

            if (sum == k) {
                if (right - left < size) {
                    size = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
            }

            right++;
        }

        return answer;
    }
}