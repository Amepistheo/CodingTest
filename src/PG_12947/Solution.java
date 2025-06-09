// 12947번 하샤드 수
package PG_12947;

class Solution {
    public boolean solution(int x) {
        boolean answer = false;

        String s = String.valueOf(x);
        String[] arr = s.split("");

        int n = 0;

        for (String c : arr) {
            n += Integer.parseInt(c);
        }

        if (x % n == 0) {
            answer = true;
        }

        return answer;
    }
}