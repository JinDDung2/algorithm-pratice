package BOJ.implementation;

import java.util.*;

public class 반복수열_2331 {

    static Map<Long, Integer> seq = new HashMap<>();
    static int B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        sc.close();
        B = input[1];

        long num = input[0];
        int idx = 0;
        seq.put(num, ++idx);
        while (true) {
            long next = getNext(num);
            if (seq.containsKey(next)) {
                System.out.println(seq.get(next) - 1);
                break;
            }
            seq.put(next, ++idx);
            num = next;
        }
    }

    private static long getNext(long num) {
        long sum = 0;
        while (num > 0) {
            sum += Math.pow(num % 10, B);
            num /= 10;
        }
        return sum;
    }
}
