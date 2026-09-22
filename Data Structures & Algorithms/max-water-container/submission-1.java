class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxArea = 0;
        int currentArea = 0;
        while (l < r){
            currentArea = (r-l) * Math.min(heights[l], heights[r]);
            if (maxArea < currentArea){
                maxArea = currentArea;
            }
            if (heights[l] < heights[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return maxArea;
    }
}
