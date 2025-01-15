// 2022 KAKAO BLIND RECRUITMENT - k진수에서 소수 개수 구하기
package PG_k진수에서_소수_개수_구하기;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] arr = Integer.toString(n, k).split("0");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].isEmpty() || arr[i].equals("1")) {
                continue;
            }

            long num = Long.parseLong(arr[i]);
            int count = 0;

            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    count++;
                    break;
                }
            }

            if (count == 0) {
                answer++;
            }
        }

        return answer;
    }
}