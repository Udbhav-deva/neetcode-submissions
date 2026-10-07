class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int left = 0;
        int maxFrequency = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            counts[rightChar - 'A']++;
            maxFrequency = Math.max(maxFrequency, counts[rightChar - 'A']);
            if ((right - left + 1) - maxFrequency > k) {
                char leftChar = s.charAt(left);
                counts[leftChar - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
