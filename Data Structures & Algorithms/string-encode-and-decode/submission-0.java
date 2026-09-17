class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++){
            String current = strs.get(i);
            int length = current.length();
            sb.append(length + "#" + current);
        }
        String encoded_string = sb.toString();
        return encoded_string;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int j = 0;
        while (j < str.length()){
            int delimiter = str.indexOf('#', j);
            String substring = str.substring(j, delimiter);
            int convert = Integer.parseInt(substring);
            String word = str.substring(delimiter + 1, delimiter + 1 + convert);
            result.add(word);
            j = delimiter + 1 + convert;
        }
        return result;
    }
}
