// 70129번 이진 변환 반복하기
package PG_70129;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count = 0;
        int zero = 0;

        while (!s.equals("1")) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zero++;
                }
            }

            s = s.replace("0", "");
            s = Integer.toString(s.length(), 2);
            count++;
        }

        answer[0] = count;
        answer[1] = zero;

        return answer;
    }
}