class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> map = new HashMap<>();
       for (int i = 0; i < nums.length; i++){
        int need = target - nums[i];
        if (!map.containsKey(need)){
            map.put(nums[i], i);
        }
        else{
            int s = map.get(need);
            return new int[] {s, i};
        }
       }
       return new int[] {};
    }
}
