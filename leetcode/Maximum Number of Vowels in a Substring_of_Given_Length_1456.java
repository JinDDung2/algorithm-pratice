class Solution {
    // 1. result: 결과값, cnt: 슬라이딩 윈도우 내의 인덱스 개수, vowelCnt: 모음 개수
    // 2. for문 돌며 cnt++
    // 2-1. 모음 있으면 vowelCnt++
    // 2-2. cnt > k && vowelCnt > 0 && i-k가 모음이라면 vowelCnt--
    // 2-3. vowelCnt == k 면 return k -> 어차피 최대값이라 더이상 안봐도 됨
    public int maxVowels(String s, int k) {
        int result = 0;
        int cnt = 0, vowelCnt = 0;
        
        for (int i = 0; i < s.length(); i++) {
            cnt++;
            if (isVowel(s.charAt(i))) vowelCnt++;
            if (cnt > k && vowelCnt > 0 && isVowel(s.charAt(i - k))) vowelCnt--;
            if (vowelCnt == k) return k;

            result = Math.max(result, vowelCnt);
        }

        return result;
    }

    public boolean isVowel (char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
