class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap <Character, Integer> map = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }
        else{
            for (int i = 0; i < s.length(); i++){
                if(map.containsKey(s.charAt(i))){
                    int count = map.get(s.charAt(i));
                    count += 1;
                    map.put(s.charAt(i), count);
                }
                else{
                    map.put(s.charAt(i), 1);
                }
            }
            for(int j = 0; j < t.length(); j++){
                if(map.containsKey(t.charAt(j))){
                    int count = map.get(t.charAt(j));
                    if(count ==  0){
                        return false;
                    }
                    else{
                        count -= 1;
                        map.put(t.charAt(j), count);
                    }
                }
                else{
                    return false;
                }
            }
        }
    return true;
    }
}
