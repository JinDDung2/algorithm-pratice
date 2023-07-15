package programmas.java.lv1;

import java.util.*;

// [lv1] 체육복 (greedy)
public class GymClothes {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 자기 자신이 갖고 있는지 확인
        for (int i=0; i<lost.length; i++) {
            for (int j=0; j<reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = reserve[j] = -1;
                    break;
                }
            }
        }
        
        for (int l: lost) {
            for (int i=0; i<reserve.length; i++) {
                if ((l-1) == reserve[i] || (l+1) == reserve[i]) {
                    reserve[i] = -1;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
