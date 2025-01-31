// 12941번 최솟값 만들기
package PG_12941;

import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int i = 0; i < A.length; i++) {
            answer += (A[i] * B[B.length - i - 1]);
        }

        return answer;
    }
}