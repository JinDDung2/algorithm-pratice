package programmas.java.lv2;

import java.util.Arrays;

public class DigUpMineral {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int[][] section = new int[minerals.length / 5 + 1][3];
        int num = picks[0] + picks[1] + picks[2];

        for (int i = 0; i < minerals.length && num > 0; i++) {
            switch (minerals[i]) {
                case "diamond":
                    section[i / 5][0] += 1;
                    section[i / 5][1] += 5;
                    section[i / 5][2] += 25;
                    break;
                case "iron":
                    section[i / 5][0] += 1;
                    section[i / 5][1] += 1;
                    section[i / 5][2] += 5;
                    break;
                case "stone":
                    section[i / 5][0] += 1;
                    section[i / 5][1] += 1;
                    section[i / 5][2] += 1;
            }
            if (i % 5 == 4)
                num--;
        }

        for (int[] sect : section) {
            System.out.println(Arrays.toString(sect));
        }

        // 피로도 낮은 순 오름차순
        Arrays.sort(section, (o1, o2) -> (o2[2] - o1[2]));
        for (int[] sect : section) {
            System.out.println(Arrays.toString(sect));
        }

        // 다이아 -> 철 -> 돌 순으로 캐기
        for (int i = 0, pick = 0; i < section.length; i++) {
            while (pick < 3 && picks[pick] == 0)
                pick++;
            if (pick == 3)
                break;
            picks[pick]--;
            answer += section[i][pick];
        }
        return answer;
    }
}
