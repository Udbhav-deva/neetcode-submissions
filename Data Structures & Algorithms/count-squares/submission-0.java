class CountSquares {
private int[][] counts;
    private List<int[]> points;

    public CountSquares() {
        counts = new int[1001][1001];
        points = new ArrayList<>();
    }

    public void add(int[] point) {
        counts[point[0]][point[1]]++;
        points.add(point);
    }

    public int count(int[] point) {
        int px = point[0];
        int py = point[1];
        int totalSquares = 0;

        for (int[] p : points) {
            int x = p[0];
            int y = p[1];

            if (Math.abs(px - x) != Math.abs(py - y) || px == x || py == y) {
                continue;
            }

            totalSquares += counts[x][py] * counts[px][y];
        }

        return totalSquares;
    }
}
