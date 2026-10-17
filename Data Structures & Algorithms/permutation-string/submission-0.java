class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < len1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len2 - len1; i++) {
            // If frequencies match, a permutation is found
            if (matches(s1Count, s2Count)) return true;
            
            // Move window: include the next character on the right
            s2Count[s2.charAt(i + len1) - 'a']++;
            // Remove the leftmost character of the old window
            s2Count[s2.charAt(i) - 'a']--;
        }
        
        // Check the very last window position
        return matches(s1Count, s2Count);
    }
    
    // Helper function to check if two frequency arrays are identical
    private boolean matches(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) return false;
        }
        return true;
    }
}
