// 2739번 구구단
package BOJ_2739;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i=1; i<10; i++) {
            System.out.println(n + " * " + i + " = " + n*i);
        }
    }
}
