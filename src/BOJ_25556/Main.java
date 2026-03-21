// 25556번 포스택
package BOJ_25556;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        Stack<Integer> s4 = new Stack<>();

        s1.push(0);
        s2.push(0);
        s3.push(0);
        s4.push(0);

        boolean isClean = true;

        for (int i = 0; i < N; i++) {
            if (s1.peek() < arr[i]) {
                s1.push(arr[i]);
            } else if (s2.peek() < arr[i]) {
                s2.push(arr[i]);
            } else if (s3.peek() < arr[i]) {
                s3.push(arr[i]);
            } else if (s4.peek() < arr[i]) {
                s4.push(arr[i]);
            } else {
                isClean = false;
                break;
            }
        }

        if (isClean) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}