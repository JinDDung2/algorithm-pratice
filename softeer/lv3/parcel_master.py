# 택배 마스터 광우

import sys
from itertools import permutations
input = sys.stdin.readline

N, M, K = map(int, input().split())
data = list(map(int, input().split()))
result = sys.maxsize

for p in permutations(data, N):
    workCount = 0
    bucket = 0
    idx = 0
    tempWeight = 0
    while workCount < K:
        if bucket + p[idx % N] <= M:
            bucket += p[idx % N]
            idx += 1
        else:
            workCount += 1
            tempWeight += bucket
            bucket = 0
    result = min(result, tempWeight)

print(result)

<<<<<<< HEAD
'''java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[] data = new int[N];
        for (int i=0; i<N; i++) {
            data[i] = sc.nextInt();
        }

        int result = Integer.MAX_VALUE;
        List<List<Integer>> permutations = new ArrayList<>();
        makePermutations(data, new ArrayList<>(), new boolean[N], permutations);

        for (List<Integer> permutation : permutations) {
            int workCount = 0;
            int bucket = 0;
            int idx = 0;
            int tempResult = 0;
            while (workCount < K) {
                if (bucket + permutation.get(idx % N) <= M) {
                    bucket += permutation.get(idx % N);
                    idx++;
                } else {
                    workCount++;
                    tempResult += bucket;
                    bucket = 0;
                }
            }

            result = Math.min(result, tempResult);
        }
        System.out.println(result);
    }

    public static void makePermutations(int[] data, List<Integer> permutation, boolean[] visited, List<List<Integer>> permutations) {
        if (permutation.size() == data.length) {
            permutations.add(new ArrayList<>(permutation));
        }

        for (int i = 0; i < data.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation.add(data[i]);
                makePermutations(data, permutation, visited, permutations);
                visited[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
'''

=======
>>>>>>> 17475ae1aa38099db90c594065d57465e509fbf9
'''test 1
N, M, K = map(int, input().split())
weights = list(map(int, input().split()))

weights_info = permutations(weights, N)
result = sys.maxsize

for info in weights_info:
    info = list(info)

    idx = 0
    bucket = 0
    work = 0
    temp_weight = 0

    while work < K:
        if bucket + info[idx] <= M:
            bucket += info[idx]
            info.append(info[idx])
            idx += 1
        else:
            temp_weight += bucket
            bucket = 0
            work += 1

    result = min(result, temp_weight)

print(result)
'''