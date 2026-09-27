class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }
        Arrays.sort(cars, (a,b) -> Double.compare(b[0], a[0])); 

        // Maintaining two objects, Fleet count and current/previous fleet time ~ 
        int count = 0;
        double previousTime = 0;
        for(int i = 0; i < cars.length; i++){
            double currentTime = cars[i][1];
            if (currentTime > previousTime){
                count++;
                previousTime = currentTime;
            }
        }
        return count;
    }
}
