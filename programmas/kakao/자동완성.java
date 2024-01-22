package programmas.kakao;

public class 자동완성 {
    // Trie 자료구조
    // 1.자도완성 가능한 단어 개수 2.다음 트라이 배열[26] 3.단어가 완성되었는지 확인
    class Trie {
        int cnt = 0;
        Trie[] next = new Trie[26];
        boolean isWord = false;
    }

    Trie root = new Trie();
    int result = 0;

    public int solution(String[] words) {
        // 트라이 만들기
        for (String word : words) {
            makeTrie(root, word);
        }
        // 자동완성 가능한 단어 탐색하는데 최소한 비용 구하기
        find(root, 0);
        return result;
    }

    private void find(Trie node, int depth) {
        // 자동완성가능한 단어가 1개일 경우
        if (node.cnt == 1) {
            result += depth;
            return;
        }
        // 이미 자동 완성 단어가 완성된 경우
        if (node.isWord == true) {
            result += depth;
        }

        // 계속 탐색
        for (int i = 0; i < 26; i++) {
            if (node.next[i] != null) {
                find(node.next[i], depth + 1);
            }
        }
    }

    private void makeTrie(Trie node, String word) {
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new Trie();
            }
            node = node.next[c - 'a'];
            node.cnt++;
        }

        node.isWord = true;
    }
}
