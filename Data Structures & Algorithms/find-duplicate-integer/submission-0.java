class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        
        do {
            slow = nums[slow];          // Moves 1 step
            fast = nums[nums[fast]];    // Moves 2 steps
        } while (slow != fast);
        
        //Find the entry point of the cycle (the duplicate number)
        int slow2 = 0;
        while (slow != slow2) {
            slow = nums[slow];        
            slow2 = nums[slow2];        
        }
        
        return slow;
    }
}
