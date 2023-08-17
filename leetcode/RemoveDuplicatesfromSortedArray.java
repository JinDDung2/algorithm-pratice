package leetcode;

public class RemoveDuplicatesfromSortedArray {
    int read;
    int write;
    public int removeDuplicates(int[] nums) {
        // nums 는 내림차순 정렬상태
        read = 1;
        write = 1;

        while (read < nums.length) {
            if (nums[read] != nums[read-1]) {
                nums[write] = nums[read];
                write++;
            }
            read++;
        }
        
        return write;
    }
}
