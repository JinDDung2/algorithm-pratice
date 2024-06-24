package programmas.kakao;

// 2020 KAKAO BLIND RECRUITMENT 가사 검색

public class 가사검색 {
    // 절레절레...

    /*
     * 시간 효율성 초과
     * Map<Integer, List<String>> wordsMap = new HashMap<>();
     * 
     * public int[] solution(String[] words, String[] queries) {
     * int n = queries.length;
     * int[] answer = new int[n];
     * 
     * for (String word : words) {
     * insert(word);
     * }
     * 
     * for (int i = 0; i < n; i++) {
     * String query = queries[i];
     * answer[i] = getMatchedWords(query);
     * }
     * 
     * return answer;
     * }
     * 
     * private void insert(String word) {
     * int len = word.length();
     * wordsMap.putIfAbsent(len, new ArrayList<>());
     * wordsMap.get(len).add(word);
     * }
     * 
     * private int getMatchedWords(String query) {
     * int len = query.length();
     * if (!wordsMap.containsKey(len)) return 0;
     * 
     * int cnt = 0;
     * for (String word : wordsMap.get(len)) {
     * if (isMatch(word, query)) {
     * cnt++;
     * }
     * }
     * 
     * return cnt;
     * }
     * 
     * private boolean isMatch(String word, String query) {
     * for (int i = 0; i < word.length(); i++) {
     * if (query.charAt(i) != '?' && query.charAt(i) != word.charAt(i)) return
     * false;
     * }
     * return true;
     * }
     */
}
