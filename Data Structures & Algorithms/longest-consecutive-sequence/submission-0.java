class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int current = 0;
        int count = 0;
        int longest = 0;
        for (int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++ ){
            if (!set.contains(nums[i]-1)){
                current = nums[i];
                count = 1;
            }
            while (set.contains(current + 1)){
                current ++;
                count ++;
            }
            if (count > longest){
                longest = count;
            }
        }   
        return longest;
    }
}