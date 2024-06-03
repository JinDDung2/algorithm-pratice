package review;

import java.util.Scanner;

public class DivideAndConquer {

    static long power(long base, long ex) {
        if (ex == 0) {
            return 1;
        } else if (ex == 1) {
            return base;
        }
        long half = power(base, ex / 2); // 만약 값이 너무 커서 a값으로 나누어야 한다면 base % a

        if (ex % 2 == 0) {
            return half * half; // 여기에서 half * half % a
        } else {
            return base * half * half; // 여기서도 base * (half * half % a) % a
        }
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 10;
        int ans = 1;
        System.out.println("power(a, b) = " + power(a, b));
    }
}
