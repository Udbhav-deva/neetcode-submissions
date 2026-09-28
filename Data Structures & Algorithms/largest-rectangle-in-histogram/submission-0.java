class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int width = 0;
        int area = 0;
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++){
            while (!stack.empty() && heights[i] < heights[stack.peek()]){
                int index = stack.pop();
                if (stack.empty()){
                    width = i;
                }
                else{
                    width = i - stack.peek() - 1;
                }
                area = heights[index] * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        while(!stack.empty()){
            int index = stack.pop();
            if (stack.empty()){
                width = heights.length;
            }
            else{
                width = heights.length - stack.peek() - 1;
            }
            area = heights[index] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
