class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++){
                int required = -(nums[i] + nums[j]);
                if (set.contains(required)){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(required);
                    Collections.sort(triplet);
                    result.add(triplet);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList(result);
    }
}
