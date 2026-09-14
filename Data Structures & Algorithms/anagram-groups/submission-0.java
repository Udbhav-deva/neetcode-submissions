class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key,list);
            }
            else{
                List<String> a= map.get(key);
                a.add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }
}
