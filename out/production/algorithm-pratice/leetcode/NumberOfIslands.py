# Number of Islands -> Time Limit Exceeded

# practice 2

# practice 1
from collections import deque

class Solution:
    def numIslands(self, grid: list[list[str]]) -> int:
        answer = 0

        que = deque()
        visited = [[False] * len(grid[0]) for _ in range(len(grid))]

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1" and not visited[i][j]:
                    self.search(grid, que, visited, i, j)
                    answer += 1
        
        # print(grid)
        return answer

    def search(self, grid, que, visited, i, j):
        dx = [1, 0,-1, 0]
        dy = [0, 1, 0, -1]
        que.append([i, j])
        while que:
            y, x = que.popleft()
            visited[y][x] = True

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                if nx < 0 or ny < 0 or nx >= len(grid[0]) or ny >= len(grid):
                    continue
                if grid[ny][nx] == "1" and not visited[ny][nx]:
                    que.append([ny, nx])

