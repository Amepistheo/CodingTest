// 1292번 쉽게 푸는 문제
package BOJ_1292;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Integer> list= new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int total = 0;

        for (int i=0; i<1000; i++) {
            for (int j=0; j<=i; j++) {
                list.add(i+1);
            }
        }

        for (int i=A-1; i<=B-1; i++) {
            total += list.get(i);
        }

        System.out.println(total);
    }
}