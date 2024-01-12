package leetcode;

// 299. Bull and Cows
public class BullsCows_299 {
    public String getHint(String secret, String guess) {
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
}
