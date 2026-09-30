class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        
        int result = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canEatInTime(piles, mid, h)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return result;
    }
    
    private boolean canEatInTime(int[] piles, int speed, int h) {
        long totalHours = 0;
        
        for (int pile : piles) {
            totalHours += (pile + speed - 1) / speed;
            
            if (totalHours > h) {
                return false;
            }
        }
        
        return totalHours <= h;
    }
}

