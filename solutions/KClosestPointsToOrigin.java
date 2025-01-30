import java.util.PriorityQueue;

class Solution {
    class Point implements Comparable<Point> {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p) {
            if (p.x*p.x + p.y*p.y < this.x*this.x + this.y*this.y) return 1;
            return -1;
        }
    }
    
    PriorityQueue<Point> pq = new PriorityQueue<>();

    public int[][] kClosest(int[][] points, int k) {
        for (int i=0; i<points.length; ++i) {
            pq.add(new Point(points[i][0], points[i][1]));
        }
        int[][] ret = new int[k][2];
        while(k-- != 0) {
            ret[k][0] = pq.peek().x;
            ret[k][1] = pq.poll().y;
        }

        return ret;
    }
}