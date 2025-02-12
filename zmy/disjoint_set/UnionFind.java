package zmy.disjoint_set;

public class UnionFind {

    static final int MAX_SIZE = 1_000;
    int[] parent = new int[MAX_SIZE];
    int[] rank = new int[MAX_SIZE];

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

    /**
     * 시간복잡도: O(logN)
     */
    void unionByRank(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    int unionForCountTotalNodes(int x, int y) {
        int[] nodeCount = new int[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            nodeCount[i] = 1;
        }

        x = find(x);
        y = find(y);

        // 두 값의 root가 같지 않으면
        if(x != y) {
            parent[y] = x; // y의 root를 x로 변경
            nodeCount[x] += nodeCount[y]; // x의 node 수에 y의 node 수를 더한다.
            nodeCount[y] = 1; // x에 붙은 y의 node 수는 1로 초기화
        }
        return nodeCount[x]; // 가장 root의 node 수 반환
    }

}
