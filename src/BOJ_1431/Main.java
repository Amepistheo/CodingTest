// 1431번 시리얼 번호
package BOJ_1431;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String[] number = new String[N];

        for (int i = 0; i < N; i++) {
            number[i] = br.readLine();
        }

        Arrays.sort(number, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    int sum1 = 0;
                    int sum2 = 0;

                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) >= '0' && o1.charAt(i) <= '9') {
                            sum1 += Integer.parseInt(String.valueOf(o1.charAt(i)));
                        }
                    }
                    for (int i = 0; i < o2.length(); i++) {
                        if (o2.charAt(i) >= '0' && o2.charAt(i) <= '9') {
                            sum2 += Integer.parseInt(String.valueOf(o2.charAt(i)));
                        }
                    }

                    if (sum1 == sum2) {
                        return o1.compareTo(o2);
                    }
                    else {
                        return sum1 - sum2;
                    }
                }
                else {
                    return o1.length() - o2.length();
                }
            }
        });

        for (int i = 0; i < N; i++) {
            sb.append(number[i]).append("\n");
        }

        System.out.print(sb);
    }
}