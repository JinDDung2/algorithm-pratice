package programmas.java.lv2;

public class BurstingBalloon {
    public int solution(int[] a) {
        if (a.length == 1) {
            return 1;
        }
        int answer = 2, n = a.length, leftMin = a[0];
        int[] rightMin = new int[n];
        rightMin[n - 1] = a[n - 1];

        for (int i = n - 2; i > 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            if (!(leftMin < a[i] && rightMin[i] < a[i])) {
                answer++;
            }

            leftMin = Math.min(leftMin, a[i]);
        }

        return answer;
    }
}
