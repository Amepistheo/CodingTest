// 2108번 통계학
package BOJ_2108;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr  = new int[8001];

        int min = 4000;
        int max = -4000;
        int sum = 0;

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num > max)
                max = num;
            if(num < min)
                min = num;

            arr[num+4000]++;
            sum += num;
        }

        int midSum = 0;
        int midVal = 0;
        int maxFreq = 0;
        int freq = 0;
        int prevFreq = 0;

        for(int i=arr.length-1; i>=0; i--) {
            if(arr[i] > 0) {
                if (midSum < (N / 2) + 1) {
                    midSum += arr[i];
                    midVal = i - 4000;
                }

                if(maxFreq < arr[i]) {
                    maxFreq = arr[i];
                    freq = i - 4000;
                    prevFreq = i - 4000;
                }
                else if(maxFreq == arr[i]) {
                    freq = prevFreq;
                    prevFreq = i - 4000;
                }
            }
        }

        sb.append(Math.round((float)sum/N)).append("\n");
        sb.append(midVal).append("\n");
        sb.append(freq).append("\n");
        sb.append(max-min).append("\n");

        System.out.print(sb);
    }
}