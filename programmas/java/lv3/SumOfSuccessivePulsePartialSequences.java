package programmas.java.lv3;

public class SumOfSuccessivePulsePartialSequences {
    public long solution(int[] sequence) {
        long answer = 0;
        int n = sequence.length;

        long[] posDp = new long[n];
        long[] negDp = new long[n];

        posDp[0] = sequence[0];
        negDp[0] = -sequence[0];

        answer = Math.max(posDp[0], negDp[0]);

        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                posDp[i] = Math.max(sequence[i], posDp[i - 1] + sequence[i]);
                negDp[i] = Math.max(-sequence[i], negDp[i - 1] - sequence[i]);
            } else {
                posDp[i] = Math.max(-sequence[i], posDp[i - 1] - sequence[i]);
                negDp[i] = Math.max(sequence[i], negDp[i - 1] + sequence[i]);
            }

            answer = Math.max(answer, Math.max(posDp[i], negDp[i]));
        }

        return answer;
    }
}
