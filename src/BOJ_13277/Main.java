// 13277번 큰 수 곱셈
package BOJ_13277;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        BigInteger A = sc.nextBigInteger();
        BigInteger B = sc.nextBigInteger();

        System.out.println(A.multiply(B));
    }
}