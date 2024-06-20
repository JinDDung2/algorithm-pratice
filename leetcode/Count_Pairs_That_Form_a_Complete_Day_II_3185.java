class Count_Pairs_That_Form_a_Complete_Day_II_3185 {
    public long countCompleteDayPairs(int[] hours) {
        // 배열 담을 24개 공간 0~23시
        // 해당 인덱스는 해당 데이터 개수
        // result += (24 - h) 인덱스의 개수
        long result = 0;
        int[] cnt = new int[24];

        for (int i = 0; i < hours.length; i++) {
            int h = hours[i] % 24;
            result += cnt[(24 - h) % 24];
            cnt[h]++;
        }

        return result;
    }
}
