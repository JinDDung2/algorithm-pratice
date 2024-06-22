package nhncommerce2023;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        Test4 test4 = new Test4();
        int[] cards = { 2, 4, 5, 2 };
        int k = 9;
        test4.solution(cards, k);
    }

    public int solution(int[] cards, int k) {
        int answer = 0;

        int size = (k / cards.length) + 1;
        System.out.println(size);
        int[] arr = new int[cards.length * size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = cards[i % 4] * ((i / cards.length) + 1);
        }

        System.out.println(Arrays.toString(arr));
        return answer;
    }
}