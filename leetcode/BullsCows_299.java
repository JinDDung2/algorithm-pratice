package leetcode;

// 299. Bull and Cows
public class BullsCows_299 {
    public String getHintV2(String secret, String guess) {
        int bull = 0;
        int cow = 0;

        int[] sArr = new int[10];
        int[] gArr = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s != g) {
                sArr[s - '0']++;
                gArr[g - '0']++;
            } else {
                bull++;
            }
        }

        for (int i = 0; i < 10; i++) {
            cow += Math.min(sArr[i], gArr[i]);
        }

        String result = bull + "A" + cow + "B";

        return result;
    }

    public String getHintV0(String secret, String guess) {
        // 숫자 위치 모두 같으면 A
        // 숫자는 같으나 위치가 다르면 B
        int n = secret.length();
        boolean[] b1 = new boolean[n];
        boolean[] b2 = new boolean[n];
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < n; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls++;
                b1[i] = b2[i] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            char s = secret.charAt(i);
            for (int j = 0; j < n; j++) {
                char g = guess.charAt(j);
                if (s == g && !b1[i] && !b2[j]) {
                    cows++;
                    b1[i] = true;
                    b2[j] = true;
                }
            }
        }

        String result = bulls + "A" + cows + "B";
        return result;
    }
}
