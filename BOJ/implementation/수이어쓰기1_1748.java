package BOJ.implementation;

import java.util.Scanner;

public class 수이어쓰기1_1748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int result = 0, len = 1;
        int end = 9, start = 1;

        while (N > end) {
            result += (end - start + 1) * len;
            len++;
            start *= 10;
            end = end * 10 + 9;
        }

        result += (N - start + 1) * len;
        System.out.println(result);
        sc.close();
    }
}
