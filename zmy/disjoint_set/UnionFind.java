package zmy.disjoint_set;

public class UnionFind {

    static final int MAX_SIZE = 1_000;
    int[] parent = new int[MAX_SIZE];

    int[] solution() {
        for (int i = 0; i < MAX_SIZE; i++)
            parent[i] = i;

        return parent;
    }

    /**
     * 재귀 이용
     * 시간복잡도 O(N)
     */
    // O(N)
    int find(int x) {
        // 루트 노드는 부모 노드 번호로 자기 자신을 가진다.
        if (parent[x] == x) {
            return x;
        } else {
            // 각 노드의 부모 노드를 찾아 올라간다.
            return find(parent[x]);
        }
    }

    /**
     * 시간복잡도: O(N)
     */
    void union(int x, int y) {
        // 각 원소가 속한 트리의 루트 노드를 찾는다.
        x = find(x);
        y = find(y);

        parent[y] = x;
    }

}
