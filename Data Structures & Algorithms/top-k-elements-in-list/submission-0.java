class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[k];
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                int count = map.get(nums[i]);
                count += 1;
                map.put(nums[i], count);
            }
            else{
                map.put(nums[i],1);
            }
        }
        for (int j = 0; j < k; j++){
            int max = 0;
            int key = 0;
            for (Map.Entry<Integer,Integer> entry : map.entrySet()){
                if (entry.getValue() > max){
                    max = entry.getValue();
                    key = entry.getKey();
                    
                }
            }
            result[j] = key;
            map.remove(key);
        }
        return result;
    }
}
