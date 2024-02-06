// 10156번 과자
package BOJ_10156;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int price = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());

        int need = (price * num) - money;

        if (need >= 0) {
            System.out.println(need);
        }
        else {
            System.out.println(0);
        }
    }
}