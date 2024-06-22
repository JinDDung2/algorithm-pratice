package nhncommerce2023;

public class Test1 {
    public int solution(int[][] flowers) {
        int answer = 0;
        boolean[] isflower = new boolean[366];

        for (int i = 0; i < flowers.length; i++) {
            int[] flower = flowers[i];
            for (int j = flower[0]; j < flower[1]; j++) {
                isflower[j] = true;
            }
        }

        for (int i = 1; i <= 365; i++) {
            answer += isflower[i] == true ? 1 : 0;
        }

        return answer;
    }
}
