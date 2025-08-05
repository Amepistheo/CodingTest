// 12915번 문자열 내 마음대로 정렬하기
package PG_12915;

import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] arr = new String[strings.length];

        for (int i = 0; i < strings.length; i++) {
            arr[i] = (strings[i].charAt(n) + strings[i]);
        }

        Arrays.sort(arr);

        for (int i = 0; i < strings.length; i++) {
            arr[i] = arr[i].substring(1);
        }

        return arr;
    }
}