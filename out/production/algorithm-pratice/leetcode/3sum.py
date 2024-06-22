# 15. 3Sum / 1hour

class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        answer = set()
        nums.sort()
        start = 0
        left = 1
        right = len(nums)-1
        sums = 0

        if len(nums) < 3:
            return []
        
        while start < len(nums)-2:
            
            sums = nums[start] + nums[left] + nums[right]
            if left >= right:
                start += 1
                left = start + 1
                right = len(nums)-1
                continue

            if sums == 0:
                answer.add((nums[start], nums[left], nums[right]))
                right -= 1
            elif sums > 0:
                right -= 1
            else:
                left += 1
            # print(f"start={start}, left={left}, right={right}, sums={sums} answer={answer}")
        return list(answer)